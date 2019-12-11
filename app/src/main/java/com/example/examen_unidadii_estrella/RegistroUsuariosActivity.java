package com.example.examen_unidadii_estrella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuariosActivity extends AppCompatActivity{

    private EditText txtNombreUsu;
    private EditText txtDniUsu;
    private EditText txtFechaNacimientoUsu;
    private EditText txtDireccionUsu;
    private EditText txtCelularUsu;
    private EditText txtEmailUsu;
    private EditText txtPasswordUsu;
    private Button btnRegistrar;

    //Variables de los Datos que vamos a Registrar



    FirebaseAuth auth;
    DatabaseReference databaseReference;


    //LOGIN SILENCIOSO
    private GoogleApiClient googleApiClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        txtNombreUsu = (EditText) findViewById(R.id.txtNombreUsu);
        txtDniUsu = (EditText) findViewById(R.id.txtDniUsu);
        txtFechaNacimientoUsu = (EditText) findViewById(R.id.txtFechaNacimientoUsu);
        txtDireccionUsu = (EditText) findViewById(R.id.txtDireccionUsu);
        txtCelularUsu = (EditText) findViewById(R.id.txtCelularUsu);
        txtEmailUsu = (EditText) findViewById(R.id.txtEmailUsu);
        txtPasswordUsu = (EditText) findViewById(R.id.txtPasswordUsu);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabla_usuario= database.getReference("usuario");

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(RegistroUsuariosActivity.this);
                mDialog.setMessage("Porfavor espere");
                mDialog.show();

                tabla_usuario.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //Verificar si ya existe el usuario
                        if(dataSnapshot.child(txtEmailUsu.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(RegistroUsuariosActivity.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss();
                            Usuario user = new Usuario(
                                        txtNombreUsu.getText().toString().trim(),
                                        txtDniUsu.getText().toString().trim(),
                                        txtFechaNacimientoUsu.getText().toString().trim(),
                                        txtDireccionUsu.getText().toString().trim(),
                                        txtCelularUsu.getText().toString().trim(),
                                        txtEmailUsu.getText().toString().trim(),
                                        txtPasswordUsu.getText().toString().trim());

                            tabla_usuario.child(txtPasswordUsu.getText().toString()).setValue(user);

                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }



}
