package com.nineinfosys.heatconverter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.nineinfosys.heatconverter.ConverterActivity.FuelEfficiencyMassActivity;
import com.nineinfosys.heatconverter.ConverterActivity.FuelEfficiencyVolumeActivity;
import com.nineinfosys.heatconverter.ConverterActivity.HeatDensityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.HeatFluxDensityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.HeatTransferCoefficientActivity;
import com.nineinfosys.heatconverter.ConverterActivity.SpecificHeatCapacityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.TemperatureIntervalActivity;
import com.nineinfosys.heatconverter.ConverterActivity.ThermalConductivityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.ThermalExpansionActivity;
import com.nineinfosys.heatconverter.ConverterActivity.ThermalResistanceActivity;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.ItemObject;

import java.util.List;


/**
 * Created by AndriodDev5 on 18-04-2017.
 */

public class RecyclerViewHeatAdapter extends RecyclerView.Adapter<RecyclerViewHeatAdapter.RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewHeatAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView countryName;
        public ImageView countryPhoto;


        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            countryName = (TextView)itemView.findViewById(R.id.country_name);
            countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);

        }

        @Override
        public void onClick(View view) {
          //  Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
            switch (getPosition())
            {
                case 0:
                    Intent i=new Intent(context,FuelEfficiencyMassActivity.class);
                    context.startActivity(i);
                    break;
                case 1:
                    Intent i1=new Intent(context,FuelEfficiencyVolumeActivity.class);
                    context.startActivity(i1);
                    break;
                case 2:
                    Intent i2=new Intent(context,TemperatureIntervalActivity.class);
                    context.startActivity(i2);
                    break;
                case 3:
                    Intent i3=new Intent(context,ThermalExpansionActivity.class);
                    context.startActivity(i3);

                    break;
                case 4:
                    Intent i4=new Intent(context,ThermalResistanceActivity.class);
                    context.startActivity(i4);
                    break;
                case 5:
                    Intent i5=new Intent(context,ThermalConductivityActivity.class);
                    context.startActivity(i5);
                    break;
                case 6:
                Intent i6=new Intent(context,SpecificHeatCapacityActivity.class);
                context.startActivity(i6);
                break;
                case 7:
                    Intent i7=new Intent(context,HeatDensityActivity.class);
                    context.startActivity(i7);
                    break;
                case 8:
                    Intent i8=new Intent(context,HeatFluxDensityActivity.class);
                    context.startActivity(i8);
                    break;
                case 9:
                    Intent i9=new Intent(context,HeatTransferCoefficientActivity.class);
                    context.startActivity(i9);
                    break;



            }


        }



    }
}