public class Main1Activity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_image);

        String http = "http://img4.duitang.com/uploads/item/" +
                "201403/27/20140327194516_SaKBX.png";
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        //�����첽���񣬼�������ͼƬ
        new LoadImagesTask(imageView).execute(http);
    }
}