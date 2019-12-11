package com.example.examen_unidadii_estrella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {

    DatabaseReference reference, reference2;

    RecyclerView recyclerView;
    ArrayList<Producto> list;

    MyAdapterP adapter;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);


        //***********PERSONALIZA EL ACTIONBAR *********************
        ActionBar actionBar = getSupportActionBar();
        String titulo = "NUESTROS PRODUCTOS";
        actionBar.setTitle(titulo);
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.material_deep_brown)));
        //************************************************************

        preferences = this.getSharedPreferences("My_Pref", MODE_PRIVATE);

        recyclerView =(RecyclerView)findViewById(R.id.rv_productos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Producto>();

        getDatos();


    }


    public void getDatos(){

        reference = FirebaseDatabase.getInstance().getReference().child("productos");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list.removeAll(list);
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    Producto p = dataSnapshot1.getValue(Producto.class);

                    list.add(p);

                }
                adapter = new MyAdapterP(ProductosActivity.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProductosActivity.this, "Opps.. Algo salió mal", Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        int id = item.getItemId();
        if(id == R.id.sorting){
            sortDailog();
            return true;
        }
        else if(id ==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void sortDailog(){
        String[] options={"A-Z","Z-A"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Orden de");
        builder.setIcon(R.drawable.ic_action_ssort);

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort","A-Z");
                    editor.apply();
                    getDatos();
                }
                if(which == 1){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort","Z-A");
                    editor.apply();
                    getDatos();
                }
            }
        });
        builder.create().show();
    }
*/

}
