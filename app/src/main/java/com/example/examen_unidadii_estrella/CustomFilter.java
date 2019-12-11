package com.example.examen_unidadii_estrella;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    ArrayList<Producto> filterList;
    MyAdapterP adapter;

    public CustomFilter(ArrayList<Producto> filterList, MyAdapterP adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults results = new FilterResults();
        if(constraint != null && constraint.length()>0){
            constraint=constraint.toString().toUpperCase();
            ArrayList<Producto> filterModels = new ArrayList<>();

            for(int i=0; i<filterList.size();i++){
                if(filterList.get(i).getNombreprod().toUpperCase().contains(constraint)){
                    filterModels.add(filterList.get(i));
                }
            }

            results.count = filterModels.size();
            results.values = filterModels;
        }
        else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.productoarray = (ArrayList<Producto>) results.values;
        adapter.notifyDataSetChanged();
    }
}
