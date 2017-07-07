package pe.com.infordata.tventaserp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

import static com.squareup.timessquare.CalendarPickerView.SelectionMode.RANGE;

public class TotVentasVend extends AppCompatActivity {
    private String array_spin1[];
    private String array_spin2[];
    private String array_spin3[];
    String CasosR;
    Spinner s1;
    Spinner s2;
    Spinner s3;
    CalendarPickerView cpv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tot_ventas_vend);


        Date today=new Date();
        Calendar nextYear=Calendar.getInstance();
        nextYear.add(Calendar.YEAR,1);

        cpv=(CalendarPickerView)findViewById(R.id.calendar_view);
        cpv.init(today,nextYear.getTime()).inMode(RANGE);


        array_spin1 = new String [3];
        array_spin1[0]="Mes y Año";
        array_spin1[1]="Año";
        array_spin1[2]="Rango";
        s1=(Spinner)findViewById(R.id.tipFilt_MYR);
        ArrayAdapter adapter1= new ArrayAdapter(this,android.R.layout.simple_spinner_item,array_spin1);
        s1.setAdapter(adapter1);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int sp1_pos=s1.getSelectedItemPosition();
                s3.setVisibility(View.GONE);
                s2.setVisibility(View.GONE);
                switch (sp1_pos){
                    case 0:CasosR="M";
                        s2.setVisibility(View.VISIBLE);
                        s3.setVisibility(View.VISIBLE);
                        break;
                    case 1:CasosR="Y";
                        s2.setVisibility(View.GONE);
                        s3.setVisibility(View.VISIBLE);

                        break;
                    case 2:CasosR="R";
                        cpv.setVisibility(View.VISIBLE);

                        break;
                }
                System.out.println(CasosR);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        array_spin2 = new String [12];
        array_spin2[0]="Ene";
        array_spin2[1]="Feb";
        array_spin2[2]="Mar";
        array_spin2[3]="Abr";
        array_spin2[4]="May";
        array_spin2[5]="Jun";
        array_spin2[6]="Jul";
        array_spin2[7]="Ago";
        array_spin2[8]="Sept";
        array_spin2[9]="Oct";
        array_spin2[10]="Nov";
        array_spin2[11]="Dic";
        s2=(Spinner)findViewById(R.id.filt_M);
        ArrayAdapter adapter2= new ArrayAdapter(this,android.R.layout.simple_spinner_item,array_spin2);
        s2.setAdapter(adapter2);



        array_spin3 = new String [8];
        array_spin3[0]="2017";
        array_spin3[1]="2016";
        array_spin3[2]="2015";
        array_spin3[3]="2014";
        array_spin3[4]="2013";
        array_spin3[5]="2012";
        array_spin3[6]="2011";
        array_spin3[7]="2010";


        s3=(Spinner)findViewById(R.id.filt_Y);
        ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_spinner_item,array_spin3);
        s3.setAdapter(adapter);



    }

}
