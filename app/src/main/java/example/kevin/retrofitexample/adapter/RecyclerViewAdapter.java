package example.kevin.retrofitexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.kevin.retrofitexample.R;
import example.kevin.retrofitexample.model.NoticiasModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    public List<NoticiasModel> mList;



    public RecyclerViewAdapter(List<NoticiasModel> list){
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticia,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        String nombres = mList.get(position).getUsuario().getNombre() + " "+mList.get(position).getUsuario().getApellido();

        holder.nombreCompleto.setText(nombres);
        holder.lugar.setText(mList.get(position).getLugar());
        holder.noticia.setText(mList.get(position).getNoticia());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombreCompleto,lugar,noticia;


        public ViewHolder(View itemView) {
            super(itemView);
            nombreCompleto = itemView.findViewById(R.id.tvNombreCompleto);
            lugar = itemView.findViewById(R.id.tvLugar);
            noticia = itemView.findViewById(R.id.tvNoticia);

        }
    }
}
