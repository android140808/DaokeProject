package avater.appscomm.com.wanandroid;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import avater.appscomm.com.wan_andoid.R;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout refresh;
    private ListView list_view;
    private List<String> data;
    private MyAdapter adapter;
    private Button add;
    private Button delete;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refresh.setRefreshing(false);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refresh = findViewById(R.id.refresh);
        list_view = findViewById(R.id.list_view);
        delete = findViewById(R.id.delete);
        add = findViewById(R.id.add);
        data = new ArrayList<>();
        data.add("sfasgdfg");
        data.add("sfasgdfg");
        data.add("sfasgdfg");
        data.add("sfasgdfg");
        data.add("sfasgdfg");
        data.add("sfasgdfg");
        data.add("sfasgdfg");
        data.add("sfasgdfg");
        adapter = new MyAdapter();
        View tittle = View.inflate(this, R.layout.tittle, null);
        tittle.findViewById(R.id.tittle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了头部", Toast.LENGTH_SHORT).show();
            }
        });
        View content = View.inflate(this, R.layout.content, null);
        content.findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "你点击了内容", Toast.LENGTH_SHORT).show();
            }
        });
        list_view.addHeaderView(tittle);
        list_view.addHeaderView(content);
        list_view.setAdapter(adapter);
        list_view.setOnScrollListener(onScrollListener);
        refresh.setOnRefreshListener(onRefreshListener);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(0, "newnewnewnew");
                adapter.notifyDataSetChanged();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(data.size() - 1);
                adapter.notifyDataSetChanged();
            }
        });
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, " i == " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            try {
                mHandler.sendEmptyMessageDelayed(0, 5000);
            } catch (Exception e) {

            }
        }
    };

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null) {
                view = View.inflate(MainActivity.this, R.layout.view_content, null);
                holder = new ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.textView.setText(data.get(i));
            return view;
        }

        class ViewHolder {
            private TextView textView;

            public ViewHolder(View view) {
                this.textView = view.findViewById(R.id.text);
            }
        }
    }

    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView absListView, int i) {

        }

        @Override
        public void onScroll(AbsListView absListView, int i, int i1, int i2) {
            if (i == 0) {
                refresh.setEnabled(true);
            } else {
                refresh.setEnabled(false);
            }
        }
    };
}
