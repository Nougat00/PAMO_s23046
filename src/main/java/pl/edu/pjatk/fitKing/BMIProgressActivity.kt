package pl.edu.pjatk.fitKing

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class BMIProgressActivity : AppCompatActivity() {
    private val xValues: List<String> = mutableListOf("January", "February", "March", "April")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_progress)
        val barChart = findViewById<BarChart>(R.id.chart)
        barChart.axisRight.setDrawLabels(false)
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f, 27.9f))
        entries.add(BarEntry(1f, 27.5f))
        entries.add(BarEntry(2f, 26.9f))
        entries.add(BarEntry(3f, 26.4f))
        val yAxis = barChart.axisLeft
        yAxis.setAxisMaximum(20f)
        yAxis.setAxisMaximum(30f)
        yAxis.axisLineWidth = 2f
        yAxis.axisLineColor = Color.BLACK
        yAxis.setLabelCount(0)
        val dataSet = BarDataSet(entries, "Scale")
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
        val barData = BarData(dataSet)
        barChart.setData(barData)
        barChart.description.isEnabled = true
        barChart.invalidate()
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(xValues)
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.xAxis.setGranularity(1f)
        barChart.xAxis.isGranularityEnabled = true
    }

    fun openHomeActivity(view: View?) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
