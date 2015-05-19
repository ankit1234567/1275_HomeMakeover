package com.ravi.ravi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tab2 extends Activity {
    Button add_btn;
    ListView Contact_listview;
    ArrayList<inc> contact_data = new ArrayList<inc>();
    Contact_Adapter cAdapter;
    DBhelper2 db;
    String Toast_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);
        try {
            Contact_listview = (ListView) findViewById(R.id.list1);
            Contact_listview.setItemsCanFocus(false);
            add_btn = (Button) findViewById(R.id.add_btn1);

            Set_Referash_Data();

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("some error", "" + e);
        }
        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent add_user = new Intent(Tab2.this,
                        AddIncome.class);
                add_user.putExtra("called", "add");
                add_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(add_user);
                finish();
            }
        });

    }


    public void Set_Referash_Data() {
        contact_data.clear();
        db = new DBhelper2(this);
        ArrayList<inc> contact_array_from_db = db.Get_Contacts();

        for (int i = 0; i < contact_array_from_db.size(); i++) {

            int tidno = contact_array_from_db.get(i).getID();
            String name = contact_array_from_db.get(i).getDate();
            String mobile = contact_array_from_db.get(i).getAmount();
            String email = contact_array_from_db.get(i).getNote();
            inc cnt = new inc();
            cnt.setID(tidno);
            cnt.setDate(name);
            cnt.setNote(email);
            cnt.setAmount(mobile);

            contact_data.add(cnt);
        }
        db.close();
        cAdapter = new Contact_Adapter(Tab2.this, R.layout.listview_raw1,
                contact_data);
        Contact_listview.setAdapter(cAdapter);
        cAdapter.notifyDataSetChanged();
    }

    public void Show_Toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Set_Referash_Data();

    }

    public class Contact_Adapter extends ArrayAdapter<inc> {
        Activity activity;
        int layoutResourceId;
        inc user;
        ArrayList<inc> data = new ArrayList<inc>();

        public Contact_Adapter(Activity act, int layoutResourceId,
                               ArrayList<inc> data) {
            super(act, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.activity = act;
            this.data = data;
            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            UserHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = LayoutInflater.from(activity);

                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new UserHolder();
                holder.name = (TextView) row.findViewById(R.id.user_name_txt1);
                holder.email = (TextView) row.findViewById(R.id.user_email_txt1);
                holder.number = (TextView) row.findViewById(R.id.user_mob_txt1);
                holder.edit = (Button) row.findViewById(R.id.btn_update1);
                holder.delete = (Button) row.findViewById(R.id.btn_delete1);
                row.setTag(holder);
            } else {
                holder = (UserHolder) row.getTag();
            }
            user = data.get(position);
            holder.edit.setTag(user.getID());
            holder.delete.setTag(user.getID());
            holder.name.setText(user.getDate());
            holder.email.setText(user.getAmount());
            holder.number.setText(user.getNote());

            holder.edit.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.i("Edit Button Clicked", "**********");

                    Intent update_user = new Intent(activity,
                            AddIncome.class);
                    update_user.putExtra("called", "update");
                    update_user.putExtra("USER_ID", v.getTag().toString());
                    activity.startActivity(update_user);

                }
            });
            holder.delete.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(final View v) {
                    // TODO Auto-generated method stub

                    // show a message while loader is loading

                    AlertDialog.Builder adb = new AlertDialog.Builder(activity);
                    adb.setTitle("Delete?");
                    adb.setMessage("Are you sure you want to delete ");
                    final int user_id = Integer.parseInt(v.getTag().toString());
                    adb.setNegativeButton("Cancel", null);
                    adb.setPositiveButton("Ok",
                            new AlertDialog.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // MyDataObject.remove(positionToRemove);
                                    DBhelper2 dBHandler = new DBhelper2(
                                            activity.getApplicationContext());
                                    dBHandler.Delete_Contact(user_id);
                                    Tab2.this.onResume();

                                }
                            });
                    adb.show();
                }

            });
            return row;

        }

        class UserHolder {
            TextView name;
            TextView email;
            TextView number;
            Button edit;
            Button delete;
        }

    }

}
