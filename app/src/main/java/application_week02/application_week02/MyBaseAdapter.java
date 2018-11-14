package application_week02.application_week02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<MyBean.Result> list;

    public MyBaseAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<MyBean.Result> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public MyBean.Result getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
            holder = new ViewHolder();
            holder.text_actors = convertView.findViewById(R.id.text_actors);
            holder.text_country = convertView.findViewById(R.id.text_country);
            holder.text_known = convertView.findViewById(R.id.text_known);
            holder.text_simple = convertView.findViewById(R.id.text_simple);
            holder.text_poster = convertView.findViewById(R.id.text_poster);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
            holder.text_simple.setText(list.get(position).getPlot_simple());
            holder.text_known.setText(list.get(position).getAlso_known_as());
            holder.text_country.setText(list.get(position).getCountry());
            holder.text_actors.setText(list.get(position).getActors());
            holder.text_simple.setText(list.get(position).getPoster());
        return convertView;
    }

    class ViewHolder {
        TextView text_actors,text_known,text_country,text_simple,text_poster;
    }
}
