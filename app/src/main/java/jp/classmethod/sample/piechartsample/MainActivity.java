package jp.classmethod.sample.piechartsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PieChart mPieChart;
    int  count = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPieChart = (PieChart) findViewById(R.id.pie_chart);
        setupPieChartView();
    }

    private void setupPieChartView() {
        mPieChart.setUsePercentValues(true);

        Legend legend = mPieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);

        List<Float> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(100f);
        }

        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entries.add(new Entry(values.get(i), i));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setDrawValues(false);

        List<String> labels = new ArrayList<>();
        for (int i=0;i<count;i++){
            labels.add(i+1+"");
        }

        PieData pieData = new PieData(labels, dataSet);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(20f);
        pieData.setValueTextColor(Color.BLACK);

        mPieChart.setData(pieData);
    }

    public void start(View v){
        mPieChart.spin(30000, mPieChart.getRotationAngle(), mPieChart.getRotationAngle() + 18000, Easing.EasingOption. EaseOutQuart);
    }
    public void stop(View v){
        mPieChart.spin(5000, mPieChart.getRotationAngle(), mPieChart.getRotationAngle() + 1800, Easing.EasingOption. EaseOutQuart);
    }


}
