package com.example.picoyplacafriends.driversView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplacafriends.R;

import java.util.ArrayList;
import java.util.UUID;

public class RouteApdater  extends RecyclerView.Adapter<RouteView>{


    /**
     * Arraylist de rutas predefinidas.
     */
    private ArrayList<Route> defaultRoutes;
    private Button bt;
    /**
     * Constructor
     */
    public RouteApdater(){
        defaultRoutes = new ArrayList<>();
        defaultRoutes.add(new Route(UUID.randomUUID().toString(),"Universidad - Casa", bt));
        defaultRoutes.add(new Route(UUID.randomUUID().toString(),"Universidad - Casa", bt));
        defaultRoutes.add(new Route(UUID.randomUUID().toString(),"Universidad - Casa", bt));
    }

    /**
     * Permite generar el esqueleto convirtiendo el XML -> ViewHolder
     * @param parent Representa al recyclerView
     * @param viewType
     * @return ContactView.
     */
    @NonNull
    @Override
    public RouteView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Conversión de archivo xml -> View.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        /**
         * R.layout.default_route : Representa al XML defaylt_route en representación del viewHolder
         * parent: RecyclerView: Donde se agregará el viewHolder
         * false: Permite realizar una lista dinamica, es decir que en tiempo de ejecución
         * permite agregar elementos y borrarlos.
         */
        View row = inflater.inflate(R.layout.default_route,parent,false);
        //Creación de la parte grafica del viewHolder
        RouteView skeleton = new RouteView(row);
        return skeleton;
    }

    /**
     * Permite construir el esqueleto, tomaando el View retornado del metodo anterior y así, llenarlo de informaciónñ
     * @param position ubicación del viewholder en el recyclerView
     */
    @Override
    public void onBindViewHolder(@NonNull RouteView skeleton, int position) {
        //Se toma un contacto en la posición dada y se le agrega al viewHolder la información correspondiente
        Route route = defaultRoutes.get(position);
        skeleton.gettVHeadBoard().setText(route.getHeadBoard());
        skeleton.setBtAcceptRoute(route.getAcceptRoute());

    }

    /**
     * Permite contar cuantos elementos tiene el recycler.
     * @return
     */
    @Override
    public int getItemCount() {
        return defaultRoutes.size();
    }
}
