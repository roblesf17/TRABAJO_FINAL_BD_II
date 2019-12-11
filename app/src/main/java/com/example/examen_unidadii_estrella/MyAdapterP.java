package com.example.examen_unidadii_estrella;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapterP extends RecyclerView.Adapter<MyAdapterP.MyViewHolder> implements Filterable{

    Context context;
    ArrayList<Producto> productoarray;

    ArrayList<Producto> filterList;

    CustomFilter filter;

    public MyAdapterP(Context c, ArrayList<Producto> p) {
        context = c;
        productoarray = p;

        this.filterList = p;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.rowproductos, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.txtNombreProducto.setText(productoarray.get(position).getNombreprod());
        Picasso.get().load(productoarray.get(position).getImagenprod()).into(holder.imagenProducto);

        holder.setItemclicklistener(new itemclicklistener()
        {
            @Override
            public void onItemClickListener(View v, int position)
            {

                String gNombreProd = productoarray.get(position).getNombreprod();
                String gDescripcionProd = productoarray.get(position).getDescripcionprod();
                String gFotoProd = productoarray.get(position).getImagenprod();

                Intent intent = new Intent(context, DetalleProductoActivity.class);

                intent.putExtra("iNombreProd",gNombreProd);
                intent.putExtra("iDescripcionProd",gDescripcionProd);
                intent.putExtra("iFotoProd",gFotoProd);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return productoarray.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }

    ///////////////////////////////////////////////////////////////////

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNombreProducto;
        ImageView imagenProducto;
        itemclicklistener itemclicklistener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombreProducto =(TextView)itemView.findViewById(R.id.nombre_producto);
            imagenProducto =(ImageView)itemView.findViewById(R.id.foto_producto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemclicklistener.onItemClickListener(v,getLayoutPosition());
        }
        public void setItemclicklistener (itemclicklistener ic){

            this.itemclicklistener = ic;
        }
    }


}
