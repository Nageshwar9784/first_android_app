package com.ss.eictapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.ImageView;

        import com.denzcoskun.imageslider.ImageSlider;
        import com.denzcoskun.imageslider.constants.ScaleTypes;
        import com.denzcoskun.imageslider.models.SlideModel;

        import java.util.ArrayList;

public class SliderImage extends AppCompatActivity {
    ImageSlider slider;
    ArrayList<SlideModel> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_image);
        slider=findViewById(R.id.imageslider);
        list.add(new SlideModel("https://upload.wikimedia.org/wikipedia/commons/7/7d/Wildlife_at_Maasai_Mara_%28Lion%29.jpg", "A Lion Cub", ScaleTypes.FIT));

        slider.setImageList(list, ScaleTypes.FIT);
    }
}