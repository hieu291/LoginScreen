package sharedprefence.screen.login.com.loginscreen;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class SubActivity extends AppCompatActivity {
    GridView gridWallpaper;
    Integer[] imgWallpaper = {
            R.drawable.thumb1,
            R.drawable.thumb2,
            R.drawable.thumb3,
            R.drawable.thumb4,
            /*R.drawable.thumb5,
            R.drawable.thumb6,
            R.drawable.thumb7,
            R.drawable.thumb8,
            R.drawable.thumb9,
            R.drawable.thumb10,*/
    };
    Button btnSet;
    ImageView imgPreview;
    WallpaperManager myWallpapermanager;
    Drawable myDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        addControl();
        wallpaperacion();
        addEvent();
    }

    private void wallpaperacion() {
        myWallpapermanager = WallpaperManager.getInstance(getApplicationContext());
        myDrawable = myWallpapermanager.getDrawable();
        imgPreview.setImageDrawable(myDrawable);

    }

    private void addEvent() {

    }

    private void addControl() {
        btnSet = findViewById(R.id.btnSet);
        gridWallpaper = findViewById(R.id.gridWallpaper);
        imgPreview = findViewById(R.id.imgPreview);
        gridWallpaper.setAdapter(new Adapter(getApplicationContext()));

    }

    public class Adapter extends BaseAdapter {
        Context context;

        public Adapter(Context applicationContext) {
            context = applicationContext;
        }

        @Override
        public int getCount() {
            return imgWallpaper.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ImageView gridImageView;
            if (view == null) {
                gridImageView = new ImageView(context);
                gridImageView.setLayoutParams(new GridView.LayoutParams(512, 512));
                gridImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                gridImageView = (ImageView) view;
            }
            gridImageView.setImageResource(imgWallpaper[i]);
            gridImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*try {
                        myWallpapermanager.setResource(imgWallpaper[i]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                    imgPreview.setImageResource(imgWallpaper[i]);
                    //wallpaperacion();
                }
            });
            btnSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        myWallpapermanager.setResource(imgWallpaper[i]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    wallpaperacion();
                    Toast.makeText(SubActivity.this, "Succes", Toast.LENGTH_SHORT).show();
                }
            });


            return gridImageView;
        }
    }
}


