package pe.com.infordata.tventaserp;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.leavjenn.smoothdaterangepicker.date.SmoothDateRangePickerFragment;


public class TotVentasVend extends AppCompatActivity {
    private String array_spin1[];
    private String array_spin2[];
    private String array_spin3[];
    String CasosR;
    Spinner s1;
    Spinner s2;
    Spinner s3;
    Button btnStRg;
    String ranIni, ranFin;
    int anioAct;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tot_ventas_vend);
        anioAct = Calendar.getInstance().get(Calendar.YEAR);




        btnStRg =(Button)findViewById(R.id.btnSetRang);
        array_spin1 = new String [3];
        array_spin1[0]="Mes y Año";
        array_spin1[1]="Año";
        array_spin1[2]="Rango";
        s1=(Spinner)findViewById(R.id.tipFilt_MYR);
        ArrayAdapter adapter1= new ArrayAdapter(this,android.R.layout.simple_spinner_item,array_spin1);
        s1.setAdapter(adapter1);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int sp1_pos=s1.getSelectedItemPosition();
                s3.setVisibility(View.GONE);
                s2.setVisibility(View.GONE);
                switch (sp1_pos){
                    case 0:CasosR="M";
                        s2.setVisibility(View.VISIBLE);
                        s3.setVisibility(View.VISIBLE);
                        btnStRg.setVisibility(View.GONE);

                        break;
                    case 1:CasosR="Y";
                        s2.setVisibility(View.GONE);
                        s3.setVisibility(View.VISIBLE);
                        btnStRg.setVisibility(View.GONE);

                        break;
                    case 2:CasosR="R";
                        btnStRg.setVisibility(View.VISIBLE);
                        btnStRg.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View view) {
                                smoothDateRangePickerFragment.show(getFragmentManager(), "smoothDateRangePicker");
                            }
                        });
                        break;
                }


                System.out.println(CasosR);
                System.out.println(ranIni);
                System.out.println(ranFin);
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
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int sp2_pos=s2.getSelectedItemPosition();

                switch (sp2_pos){

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        int anioBus=anioAct-2002;
        array_spin3 = new String [anioBus];
        for (int i=0;i<=anioBus;i++){
            array_spin3[i]= String.valueOf(anioAct);
            anioAct--;

        }


        s3=(Spinner)findViewById(R.id.filt_Y);
        ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_spinner_item,array_spin3);
        s3.setAdapter(adapter);

    }
    SmoothDateRangePickerFragment smoothDateRangePickerFragment = SmoothDateRangePickerFragment.newInstance(
            new SmoothDateRangePickerFragment.OnDateRangeSetListener() {

                @Override
                public void onDateRangeSet(SmoothDateRangePickerFragment view,
                                           int yearStart, int monthStart,
                                           int dayStart, int yearEnd,
                                           int monthEnd, int dayEnd) {
                    int mesIn=monthStart+1;
                    int mesFn=monthEnd+1;

                    ranIni=dayStart+"/"+mesIn+"/"+yearStart;
                    ranFin=dayEnd+"/"+mesFn+"/"+yearEnd;

                }

            });

}
