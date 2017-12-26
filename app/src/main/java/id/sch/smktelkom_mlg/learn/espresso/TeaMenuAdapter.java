package id.sch.smktelkom_mlg.learn.espresso;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.espresso.model.Tea;

/**
 * Created by rongrong on 26/12/2017.
 */

public class TeaMenuAdapter extends ArrayAdapter<Tea> {
    private Context mContext;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public TeaMenuAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Tea currentTea = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = convertView.findViewById(R.id.tea_grid_name);
            holder.image = convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageTitle.setText(currentTea.getTeaName());
        holder.image.setImageResource(currentTea.getImageResourceId());
        return convertView;
    }

    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }
}
