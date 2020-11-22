# 2020原生Android基础实用开发

## 1、环境配置

+ 进入官网，下载Android studio安装包

> https://developer.android.google.cn/studio/

+ 安装Android studio
+ 创建项目
+ 构建项目
+ 创建手机模拟器
+ 完成

## 2、简单熟悉Android sudio开发工具

+ 熟悉界面
+ 界面布局代码以及java代码部分
+ 最后讲几个简单设置
  + 设置开发工具主题:Appearance
  + 设置代码字体大小:font
  + 后面的慢慢教...

## 3、文本TextView的使用

+ 属性
  + text:内容
  + autoLink:设置内容为链接
  + textIsSelectable：设置可复制
  + 文本内容超过一行，显示三点
    + singleLine
    + 跑马灯
      + singleLine:设置一行
      + ellipsize：设置跑马灯
      + marqueeRepeatLimit:设置无限轮播
      + 获取组件id设置setSelected

+ 事件
  + setOnClickListener:点击事件
  + setOnLongClickListener:长按事件
  + setText:动态设置内容

## 4、按钮Button的使用

+ 设置
  + 自动导入java包
    + autu Import

+ 属性
  + text:按钮内容
  + textColor：字体颜色
  + background:背景颜色
  + 自定义样式:
    + 新建一个shape的xml自定义
      + solid:背景颜色
      + corners：边角度
      + stroke:描边
+ 事件
  + setOnClickListener:点击事件
  + setOnLongClickListener:长按事件
  + android自带的Toast吐司：用来提示用户的
    + 参数1:上下文
    + 参数2：文本
    + 参数3：显示的时间

## 5、输入框EditText的使用

+ 属性:

  + text:输入内容
  + hint：提示文本
  + 自定义样式:
    + 新建一个shape的xml自定义
      + solid:背景颜色
      + corners：边角度
      + stroke:描边

+ 事件

  + setOnFocusChangeListener：获取失去焦点

+ 监听

  + addTextChangedListener：内容改变的监听
    + beforeTextChanged：获取并打印

+ **市面上好看的输入框:TextInputLayout+TextInputEditText**

  + 在build.gradle(Module:app)引入插件

  ```xml
  //    输入框
  //noinspection GradleCompatible
  implementation 'com.android.support:appcompat-v7:27.1.1'
  //noinspection GradleCompatible
  implementation 'com.android.support:design:27.+'
  ```

  + 使用模板

  ```xml
      <com.google.android.material.textfield.TextInputLayout
          android:layout_margin="10dp"
          android:padding="10dp"
          app:passwordToggleEnabled="true"
          android:layout_width="match_parent"
          android:layout_height="wrap_content" >
  
          <com.google.android.material.textfield.TextInputEditText
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:hint="提示"/>
  
      </com.google.android.material.textfield.TextInputLayout>
  ```

  

## 6、复选框CheckBox\单选框RadioButton的使用

+ 属性
  + text：内容
  + checked：勾选状态
+ 方法
  + setChecked：设置选中状态
  + isChecked：获取当前选中状态
+ 事件
  + RadioButton
    + setOnCheckedChangeListener:获取选中的是哪个单选框

## 7、下拉框Spinner使用

+ 属性
  + entries：设置静态数据
+ 事件
  + setOnItemSelectedListener:选中事件
+ 方法
  + setAdapter：设置适配器
+ 适配器
  + ArrayAdapter：简单的数组适配器
    + list<String>:数据源
    + 方法
      + notifyDataSetChanged:属性数据

## 8、图片ImageView的使用

+ 属性

  + src:静态图片
  + scaleType：图片显示类型
    + fitXY:铺满
    + center：剧中
    + fitEnd：尾部
    + fitCenter：默认剧中

+ 方法：

  + setImageResource：设置静态图片
  + setImageBitmap：设置Bitmap图片

+ 插件：Glide:显示网络图片

  + 导入

    ```xml
    //加载网络图片
    implementation 'com.github.bumptech.glide:glide:4.9.0'
    ```

  + 配置权限

    ```xml
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.INTERNET"/>
    ```

    > 注意：
    >
    > + 这里主要是INTERNET网络权限
    >
    > + 9.0以上版本,还得配置
    >
    >   ```xml
    >   <!--application属性里-->
    >   android:usesCleartextTraffic="true"
    >   <!--application标签里-->
    >   <uses-library
    >         android:name="org.apache.http.legacy"
    >         android:required="true" />
    >   ```

  + 显示网络图片

  ```java
  Glide.with(Context).load("url").into(ImageView);
  ```

  

## 9、布局layout的使用

+ 默认宽/高设定
  + wrap_content：根据内容大小而改变
  + match_parent：占满

+ LinearLayout:线性布局
  + gravity:控制内容组件
  + layout_gravity:面向父级控制自己位置
  + padding：内边距
  + layout_margin：外边距
  + **orientation**:方向
    + horizontal:横向
    + vertical:竖向
  + **layout_weight**：权重（比例分配）
+ RelativeLayout：针布局
  + 排在越后显示级别越高
    + 按钮特殊需要加：android:stateListAnimator="@null"
  + gravity:控制内容组件
  + layout_gravity:面向父级控制自己位置
  + padding：内边距
  + layout_margin：外边距
  + **layout_alignParent:面向与父容器控制位置**
  + **layout_**：面向与控件调整位置
    + layout_toLeftOf:控件的左边
    + layout_toRightOf：控件的右边
    + layout_below：控件的下面
    + layout_above：控件的上面

## 10、完成登录界面&&头部Toolbar的使用

+ Toolbar
  + 属性
    + title:标题
    + titleTextColor:标题颜色
+ 完成布局并设置id
+ 开发工具插件
  + GenerateFindViewById：获取布局id
+ 准备事件
+ 获取账号/密码验证数据
+ 完成登录---跳转页面

```java
startActivity(new Intent(getApplicationContext(),EditTextTest.class));
```

## 11、列表ListView的使用（上）

+ 属性
  + entries:默认数据
+ 事件
  + setOnItemClickListener：点击单个列表

适配器

+ ArrayAdapter：简单的数组适配器

  + list<String>:数据源
  + 方法
    + notifyDataSetChanged:属性数据

+ BaseAdapter:自定义适配器

  + 准备自定义的View模板

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout
      xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
      android:orientation="vertical"
      android:padding="10dp"
      android:layout_height="match_parent">
  
      <TextView
          android:textSize="15dp"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="name"/>
      <TextView
          android:textSize="10dp"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="age"/>
  
  </LinearLayout>
  ```

  + 准备数据的实体类

  ```java
  public class ListViewEntity {
          String name;
          String age;
  
          public ListViewEntity() {
          }
  
          public String getName() {
              return name;
          }
  
          public void setName(String name) {
              this.name = name;
          }
  
          public String getAge() {
          return age;
      }
  
      public void setAge(String age) {
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "ListViewEntity{" +
                  "name='" + name + '\'' +
                  ", age='" + age + '\'' +
                  '}';
      }
  }
  ```

  > 注意：实体类一般是以自定义的View接口来定义的。

  + 准备实体的数据

  ```java
  List<ListViewEntity> listViewEntities;
  listViewEntities  = new ArrayList<>();
  listViewEntities.add(new ListViewEntity("张三",12));
  listViewEntities.add(new ListViewEntity("李四",13));
  listViewEntities.add(new ListViewEntity("王五",14));
  ```

  + 准备一个自定义的**BaseAdapter**的类

  ```java
  private class  BaseAdapterTest extends BaseAdapter{
  
      @Override
      public int getCount() {
          return listViewEntities.size();
      }
  
      @Override
      public Object getItem(int i) {
          return listViewEntities.get(i);
      }
  
      @Override
      public long getItemId(int i) {
          return i;
      }
  
      @Override
      public View getView(int i, View view, ViewGroup viewGroup) {
          ViewHolder viewHolder = null;
          if (view == null){
              viewHolder = new ViewHolder();
              view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_listview,null);
              viewHolder.tvAge = view.findViewById(R.id.adapter_listView_tv_age);
              viewHolder.tvName = view.findViewById(R.id.adapter_listView_tv_name);
              view.setTag(viewHolder);
          }else {
              viewHolder = (ViewHolder) view.getTag();
          }
          //做数据的处理
          return view;
      }
      class ViewHolder {
          TextView tvName;
          TextView tvAge;
      }
  }
  ```

  

## 12、列表ListView的使用（下）&&优化界面跳转

+ 插件

  + android-codegenerator-plugin-intellij：代码生成器
    + 生成findByid
    + 生成adapter
    + 生成fragment的findByid
    + ...
    + 下载网站
      + 链接:https://pan.baidu.com/s/1bsZznquq_tVtmx_VzBfslQ
      + 密码:timi

+ 优化跳转界面

  + 共享元素

    + 跳转代码

    ```java
    //跳转
    Intent intent = new Intent(getApplicationContext(),ImageViewTest.class);
    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
        ListViewTest.this, new Pair[]{Pair.<View, String>create(holder.ivTest, "activtyImageTest_image")}
    ).toBundle());
    ```

    + 共享的元素

    ```xml
    android:transitionName="set_Img"
    ```

    

## 13、横向列表HorizontalListView(自定义View)的使用

+ 简单自定义View的理解
  + 通过java程序构成xml样式
  + 直接可以在xml中使用
  + 导出属性
  + ...
+ 网上复制一个横向列表的list

```java
public class HorizontalListView extends AdapterView<ListAdapter> {

    float startX;
    float startY;
    public boolean mAlwaysOverrideTouch = true;
    protected ListAdapter mAdapter;
    private int mLeftViewIndex = -1;
    private int mRightViewIndex = 0;
    protected int mCurrentX;
    protected int mNextX;
    private int mMaxX = Integer.MAX_VALUE;
    private int mDisplayOffset = 0;
    protected Scroller mScroller;
    private GestureDetector mGesture;
    private Queue<View> mRemovedViewQueue = new LinkedList<View>();
    private OnItemSelectedListener mOnItemSelected;
    private OnItemClickListener mOnItemClicked;
    private OnItemLongClickListener mOnItemLongClicked;
    private boolean mDataChanged = false;


    public HorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private synchronized void initView() {
        mLeftViewIndex = -1;
        mRightViewIndex = 0;
        mDisplayOffset = 0;
        mCurrentX = 0;
        mNextX = 0;
        mMaxX = Integer.MAX_VALUE;
        mScroller = new Scroller(getContext());
        mGesture = new GestureDetector(getContext(), mOnGesture);
    }

    @Override
    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        mOnItemSelected = listener;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClicked = listener;
    }

    @Override
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClicked = listener;
    }

    private DataSetObserver mDataObserver = new DataSetObserver() {

        @Override
        public void onChanged() {
            synchronized (HorizontalListView.this) {
                mDataChanged = true;
            }
            invalidate();
            requestLayout();
        }

        @Override
        public void onInvalidated() {
            reset();
            invalidate();
            requestLayout();
        }
    };

    @Override
    public ListAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mDataObserver);
        }
        mAdapter = adapter;
        mAdapter.registerDataSetObserver(mDataObserver);
        reset();
    }

    private synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override
    public void setSelection(int position) {
    }

    private void addAndMeasureChild(final View child, int viewPos) {
        LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        }

        addViewInLayout(child, viewPos, params, true);
        child.measure(MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.AT_MOST));
    }

    @Override
    protected synchronized void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (mAdapter == null) {
            return;
        }

        if (mDataChanged) {
            int oldCurrentX = mCurrentX;
            initView();
            removeAllViewsInLayout();
            mNextX = oldCurrentX;
            mDataChanged = false;
        }

        if (mScroller.computeScrollOffset()) {
            int scrollx = mScroller.getCurrX();
            mNextX = scrollx;
        }

        if (mNextX <= 0) {
            mNextX = 0;
            mScroller.forceFinished(true);
        }
        if (mNextX >= mMaxX) {
            mNextX = mMaxX;
            mScroller.forceFinished(true);
        }

        int dx = mCurrentX - mNextX;

        removeNonVisibleItems(dx);
        fillList(dx);
        positionItems(dx);

        mCurrentX = mNextX;

        if (!mScroller.isFinished()) {
            post(new Runnable() {
                @Override
                public void run() {
                    requestLayout();
                }
            });
        }
    }

    private void fillList(final int dx) {
        int edge = 0;
        View child = getChildAt(getChildCount() - 1);
        if (child != null) {
            edge = child.getRight();
        }
        fillListRight(edge, dx);

        edge = 0;
        child = getChildAt(0);
        if (child != null) {
            edge = child.getLeft();
        }
        fillListLeft(edge, dx);
    }

    private void fillListRight(int rightEdge, final int dx) {
        while (rightEdge + dx < getWidth() && mRightViewIndex < mAdapter.getCount()) {
            View child = mAdapter.getView(mRightViewIndex, mRemovedViewQueue.poll(), this);
            addAndMeasureChild(child, -1);
            rightEdge += child.getMeasuredWidth();
            if (mRightViewIndex == mAdapter.getCount() - 1) {
                mMaxX = mCurrentX + rightEdge - getWidth();
            }
            if (mMaxX < 0) {
                mMaxX = 0;
            }
            mRightViewIndex++;
        }
    }
    private void fillListLeft(int leftEdge, final int dx) {
        while (leftEdge + dx > 0 && mLeftViewIndex >= 0) {
            View child = mAdapter.getView(mLeftViewIndex, mRemovedViewQueue.poll(), this);
            addAndMeasureChild(child, 0);
            leftEdge -= child.getMeasuredWidth();
            mLeftViewIndex--;
            mDisplayOffset -= child.getMeasuredWidth();
        }
    }

    private void removeNonVisibleItems(final int dx) {
        View child = getChildAt(0);
        while (child != null && child.getRight() + dx <= 0) {
            mDisplayOffset += child.getMeasuredWidth();
            mRemovedViewQueue.offer(child);
            removeViewInLayout(child);
            mLeftViewIndex++;
            child = getChildAt(0);

        }

        child = getChildAt(getChildCount() - 1);
        while (child != null && child.getLeft() + dx >= getWidth()) {
            mRemovedViewQueue.offer(child);
            removeViewInLayout(child);
            mRightViewIndex--;
            child = getChildAt(getChildCount() - 1);
        }
    }

    private void positionItems(final int dx) {
        if (getChildCount() > 0) {
            mDisplayOffset += dx;
            int left = mDisplayOffset;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                int childWidth = child.getMeasuredWidth();
                child.layout(left, 0, left + childWidth, child.getMeasuredHeight());
                left += childWidth + child.getPaddingRight();
            }
        }
    }
    public synchronized void scrollTo(int x) {
        mScroller.startScroll(mNextX, 0, x - mNextX, 0);
        requestLayout();
    }
    /**
     * 上下滑动需要拦截，
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean handled = super.dispatchTouchEvent(ev);
        handled |= mGesture.onTouchEvent(ev);
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) ev.getX();
                startY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int endX = (int) ev.getX();
                int endY = (int) ev.getY();
                int dx = (int) (endX - startX);
                int dy = (int) (endY - startY);
                if (Math.abs(dx) + 50 > Math.abs(dy)) {

                } else {
                    // 上下滑动,需要拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return handled | super.dispatchTouchEvent(ev);
    }

    protected boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                              float velocityY) {
        synchronized (HorizontalListView.this) {
            mScroller.fling(mNextX, 0, (int) -velocityX, 0, 0, mMaxX, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected boolean onDown(MotionEvent e) {
        mScroller.forceFinished(true);
        return true;
    }

    private GestureDetector.OnGestureListener mOnGesture = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onDown(MotionEvent e) {
            return HorizontalListView.this.onDown(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            return HorizontalListView.this.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {

            synchronized (HorizontalListView.this) {
                mNextX += (int) distanceX;
            }
            requestLayout();
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (isEventWithinView(e, child)) {
                    if (mOnItemClicked != null) {
                        mOnItemClicked.onItemClick(HorizontalListView.this, child, mLeftViewIndex + 1 + i, mAdapter.getItemId(mLeftViewIndex + 1 + i));
                    }
                    if (mOnItemSelected != null) {
                        mOnItemSelected.onItemSelected(HorizontalListView.this, child, mLeftViewIndex + 1 + i, mAdapter.getItemId(mLeftViewIndex + 1 + i));
                    }
                    break;
                }
            }
            return true;
        }
        @Override
        public void onLongPress(MotionEvent e) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                if (isEventWithinView(e, child)) {
                    if (mOnItemLongClicked != null) {
                        mOnItemLongClicked.onItemLongClick(HorizontalListView.this, child, mLeftViewIndex + 1 + i, mAdapter.getItemId(mLeftViewIndex + 1 + i));
                    }
                    break;
                }
            }
        }
        private boolean isEventWithinView(MotionEvent e, View child) {
            Rect viewRect = new Rect();
            int[] childPosition = new int[2];
            child.getLocationOnScreen(childPosition);
            int left = childPosition[0];
            int right = left + child.getWidth();
            int top = childPosition[1];
            int bottom = top + child.getHeight();
            viewRect.set(left, top, right, bottom);
            return viewRect.contains((int) e.getRawX(), (int) e.getRawY());
        }
    };
    //解决滑动和点击冲突问题
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float endX = ev.getX();
                float endY = ev.getY();
                float dx = endX - startX;
                float dy = endY - startY;
                if (Math.abs(dx) - 10 > Math.abs(dy)) {
                    return true;
                } else if (Math.abs(dx) < Math.abs(dy) - 10) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
```

+ 在xml中使用

```xml
    <com.example.myapplication.customView.HorizontalListView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

+ HorizontalListView联系BaseAdapter使用

## 14、网格列表GridView的使用

+ 属性
  + numColumns：列数
  + verticalSpacing：行距
  + horizontalSpacing：列距离
  + columnWidth：每列的宽
  + transcriptMode：加载数据会自动下滑
+ 联系BaseAdapter适配器
+ 事件
  + setOnItemClickListener：点击事件

## 15、静态进度条xxxBar的使用（上）

+ SeekBar:拖动条
  + 属性
    + max：设置最大值
    + progress：设置当前值
    + secondaryProgress：缓存条
  + 事件
    + setOnSeekBarChangeListener：监听
      + onProgressChanged：进度发生改变时会触发
      + onStartTrackingTouch：按住`SeekBar`时会触发
      + onStopTrackingTouch：放开`SeekBar`时触发
+ ProgressBar：加载条
  + 属性
    + max：设置最大值
    + progress：设置当前值
    + secondaryProgress：缓存条
  + 方法
    + setProgress/getProgress:设置/获取当前值

+ RatingBar：评价条
  + 属性
    + numStars：设置最大值
    + rating：设置当前值
  + 方法
    + setProgress/getProgress:设置/获取当前值
+ （全部组件）组件属性
  + visibility
    + gone：消失
    + visible：可见
+ （全部组件）组件方法
  + setEnabled：设置触摸激活状态
+ 自定义样式:drawable文件创建xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android" >
    <!-- 进度条背景色 -->
    <item android:id="@android:id/background">
        <shape>
            <solid android:color="#03A9F4" />
        </shape>
    </item>
</layer-list>
```

## 16、动态进度条xxxBar+线程的使用（下）

+ 多种方法

  + **Handler+Thread**
  + AsyncTask
  + ThreadPoolExecutor
  + IntentService
  + 简书解释：https://www.jianshu.com/p/2b634a7c49ec

+ **Handler+Thread：线程（定时器/监听器）**

+ Thread启动线程

  + 解析

  > 如果启动线程，线程里的所有逻辑代码就会脱离住ui线程。

  + 启动模板

    ```java
    Thread thread = new Thread(){	//准备一个线程
        @Override
        public void run() {
            while (true){		//这是一个无限运行的线程
                try {
                    sleep(1000);	//Thread内置的方法：1秒跑一次，相当于停顿1秒，这里单位是毫秒所以得使用1000
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //编写逻辑代码
            }
        }
    };
    thread.start();//自动线程
    ```

  ```
    > 注意：
    >
    > + 如果要修改ui主线程的组件，得加上Handler的使用。负责会包错
    >
  > > Only the original thread that created a view hierarchy can touch its views.
  ```

+ Handler主线程ui机制

  + 解析

  > 他是通过**Message**传递消息，然后**Handler**接受消息并修改组件。

  + 发送消息模板

    ```java
    //准备一个消息
    private int MESSAGE_TEST1 = 0x01;
    //发送消息
    Message message = new Message();
    message.arg1 = MESSAGE_TEST1;
    handler.sendMessage(message);
    ```

  ```
    > 注意：
    >
  > + 如果是循环的线程，一定每次循环都得重新new一个新的Message对象
  
  + 接受并处理模板
  
    ```java
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.arg1 == MESSAGE_TEST1){
                //处理逻辑
            }
        }
    };
  ```

## 17、网页显示WebView的使用

+ 权限

  + 网络权限

  ```xml
  <uses-permission android:name="android.permission.INTERNET"/>
  ```

+ 应用领域

  + app显示网页
  + 简单浏览器
  + 前端App

+ 方法

  ```java
  //常用设置
  webview.setWebViewClient(new WebViewClient());//设置可操作
  WebSettings settings = webview.getSettings();//获得浏览器设置
  settings.setJavaScriptEnabled(true);  //支持js
  settings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
  settings.setSupportZoom(true);  //支持缩放
  settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); //支持内容重      新布局
  settings.supportMultipleWindows();  //多窗口
  settings.setCacheMode(WebSettings.LOAD_NO_CACHE);  //关闭webview中缓存
  settings.setAllowFileAccess(true);  //设置可以访问文件
  settings.setNeedInitialFocus(true); //当webview调用requestFocus时为webview设置节点
  settings.setBuiltInZoomControls(true); //设置支持缩放
  settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
  settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
  settings.setLoadsImagesAutomatically(true);  //支持自动加载图片
  settings.setSavePassword(true);//关闭WebView的自动保存密码功能
  //常用方法
  webview.goBack();//返回上一级
  wwebview.canGoBack();//返回是否可以返回上一级
  webview.goForward();//前进
  webview.canGoForward();//判断是否可以前进
  ```

+ 使用

  + 显示html代码

  ```java
  webview.loadDataWithBaseURL("about:blank", html,"text/html", "UTF-8",null);
  ```

  + 显示网页地址

  ```java
  webview.loadUrl("https://www.baidu.com");
  ```

+ 监听

  + setWebViewClient
    + onPageFinished：监听加载完成
  + setWebChromeClient
    + onProgressChanged：监听加载进度，100为完成

## 18、碎片界面Fragment的使用

+ 简述

  > 使用Fragment可以把屏幕划分成几块，然后进行分组，进行一个模块化管理。Fragment不能够单独使用，**需要嵌套在Activity中使用**，其生命周期也受到宿主Activity的生命周期的影响

+ 网站解析

> https://www.jianshu.com/p/a4c51309bc19

+ 使用

  + 步骤一：首先准备一个碎片存放处（占位）

  ```java
  //这里我使用线性布局，可以使用任意一个布局不会有任何影响
  <LinearLayout
  android:layout_width="match_parent"
  android:layout_height="match_parent"/>
  ```

  + 步骤二：准备一个Fregment碎片界面

  ```java
  public class FragmentTest extends Fragment {
      View view;
      @Nullable
      @Override
      public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          view = inflater.inflate(R.layout.activity_fragment_test,container,false);
          return  view;
      }
  }
  ```

  + 步骤三:替换占位

    + 方法一：连点

    ```java
    getSupportFragmentManager().beginTransaction().replace(R.id.layout,new FragmentTest()).commit();
    ```

    + 方法一：分步骤

    ```java
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();   // 开启一个事务
    transaction.replace(R.id.right_layout, fragment);
    transaction.commit();
    ```

    + 方法三：状态保持

    ```java
    //准备一个隐藏全部fragment的方法
    public void hintFragment(FragmentTransaction ft) {
        if (f1 != null) {
            ft.hide(f1);
        }
        if (f2 != null) {
            ft.hide(f2);
        }
    }
    //准备方法显示需要显示的一个fragment，
        public void showFragment(int index) {
        // Fragment事务管理器
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // 隐藏已加载过的Fragment
        hintFragment(ft);
        switch (index) {
                // 判断Fragment是否实例化，实例化过直接显示出来，否者实例化
            case 1:
                if (f1 != null) {
                    ft.show(f1);
                } else {
                    f1 = new Fragment01();
                    ft.add(R.id.content, f1);
                }
                break;
            case 2:
                if (f2 != null) {
                    ft.show(f2);
                } else {
                    f2 = new Fragment02();
                    ft.add(R.id.content, f2);
                }
                break;
        }
        ft.commit();
    }
    //最后通过点击事件显示需要显示的fragemtn
    showFragment(1);
    ```




## 19、轮播组件ViewPager的使用(上)

+ 使用范围

  + 图片查看器
  + 首页轮播图片
  + 首页多页面(fragment)
  + ....

+ 方法

  + setCurrentItem：跳转界面
    + 第二个参数为false:没有动画
  + setOffscreenPageLimit：设置缓存界面个数

+ 使用

  + 准备n个xml的界面
  + 准备一个集合，存入所有的xml界面

  ```java
  pageView = new ArrayList<View>();
  pageView.add(LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_button_test, null));
  ```

  + 设置适配器，并配置适配器

  ```java
  viewPager.setAdapter(new PagerAdapter() {
      @Override
      // 获取当前窗体界面数
      public int getCount() {
          // TODO Auto-generated method stub
          return pageView.size();
      }
  
      @Override
      // 断是否由对象生成界面
      public boolean isViewFromObject(View arg0, Object arg1) {
          // TODO Auto-generated method stub
          return arg0 == arg1;
      }
  
      // 是从ViewGroup中移出当前View
      public void destroyItem(View arg0, int arg1, Object arg2) {
          ((ViewPager) arg0).removeView(pageView.get(arg1));
      }
  
      // 返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
      public Object instantiateItem(View arg0, int arg1) {
          ((ViewPager) arg0).addView(pageView.get(arg1));
          return pageView.get(arg1);	
      }
  });
  ```

  

## 20、轮播组件ViewPager+Fragment+Tab的使用(下)

+ 三方插件:TabLayout

```xml
implementation 'com.android.support:design:23.1.1'
```

+ ViewPage+Fragment

```java
//---准备数据
final List<Fragment> list2 = new ArrayList<>();
list2.add(new Fragment01());
list2.add(new Fragment02());
//----设置显示
mPageViewVpTest.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list2.get(position);
    }

    @Override
    public int getCount() {
        return list2.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
});
```

> 使用场景
>
> + 主页
> + 轮播图
> + 引导页面
> + ...

+ TabLayout使用

```java
//---准备标题数据
final List<String> titles = new ArrayList<>();
titles.add("标题1");
titles.add("标题2");
//---重写适配器方法
@Nullable
@Override
public CharSequence getPageTitle(int position) {
    return titles.get(position);
}
//---设置关联
TabLayout.setupWithViewPager(viewPager);
```

+ 过时处理

```java
FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
```

> *兼容以前那种方式实现的懒加载*

## 21、侧滑菜单栏 SlidingPaneLayout||DrawerLayout 的使用

+ SlidingPaneLayout

  + 推荐简述

  > https://www.jianshu.com/p/feaf6cc7406e

  + 简单实现

  ```xml
  <androidx.slidingpanelayout.widget.SlidingPaneLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent">
          <LinearLayout
              android:background="#123"
              android:layout_width="240dp"
              android:layout_gravity="left"
              android:layout_height="match_parent"></LinearLayout>
          <LinearLayout
              android:background="#543"
              android:layout_gravity="right"	
              android:layout_width="match_parent"
              android:layout_height="match_parent">
              <ImageView
                  android:layout_width="match_parent"
                  android:layout_height="match_parent"
                  android:src="@mipmap/ic_launcher"/>
          </LinearLayout>
      </androidx.slidingpanelayout.widget.SlidingPaneLayout>
  ```

  > 注意：
  >
  > + layout_gravity：设置模块类型

  + 配合Fragment使用

  ```java
  getSupportFragmentManager().beginTransaction().replace(R.id.layout,new Fragment()).commit();
  ```

  > 注意：
  >
  > + 其实就是利用Fragment的特性，替换Layout

  + 属性

    + 设置透明颜色

    ```java
    SlidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);//设置面板的侧滑渐变色
    ```

    + 打开/关闭-Api

    ```java
    SlidingPaneLayout.openPane();//SlidingPaneLayout.closePane();/
    ```

  + 设置显示样式

    ```java
    final View leftView = SlidingPaneLayout.getChildAt(0);   //获取滑动的第一个View
    //设置滑动样式监听
    SlidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
        @Override
        public void onPanelSlide(View panel, float slideOffset) {
            //panel：移动的View,slideOffset：移动的值
            //覆盖界面
            leftView.setScaleX(0.8f + 0.2f * slideOffset);//0.8~1//设置X偏移
            leftView.setScaleY(0.8f + 0.2f * slideOffset);//0.8~1//设置y偏移
            leftView.setAlpha(0.8f + 0.2f * slideOffset);//0.8~1//设置透明度
            //主界面
            panel.setScaleX(1 - 0.2f * slideOffset);//1~0.8 //设置X偏移
            panel.setScaleY(1 - 0.2f * slideOffset);//1~0.8//设置y偏移
            panel.setAlpha(1 - 0.8f * slideOffset);//1~0.8//设置透明度
    
        }
    
        @Override
        public void onPanelOpened(View panel) {
    
        }
    
        @Override
        public void onPanelClosed(View panel) {
    
        }
    });
    ```

+ DrawerLayout 

  + 简单使用

  ```xml
      <androidx.drawerlayout.widget.DrawerLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent">
          <LinearLayout
              android:layout_width="match_parent"
              android:layout_height="match_parent"/>
          <LinearLayout
              android:background="#432"
              android:layout_gravity="start"
              android:layout_width="240dp"
              android:layout_height="match_parent"/>
      </androidx.drawerlayout.widget.DrawerLayout>
  ```

  > 注意：
  >
  > +   layout_gravity="start":决定覆盖模块

  + 属性方法:打开/关闭

  ```java
  DrawerLayout.openDrawer(Gravity.LEFT);//   DrawerLayout.closeDrawer(Gravity.LEFT);//
  ```

+ 默认侧拉模块

+ 完全恢复工具

## 22、下拉刷新SwipeRefreshLayout的使用

+ 条件

  + 只能有一个根元素

+ 使用

  ```xml
  <androidx.swiperefreshlayout.widget.SwipeRefreshLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent">
          <LinearLayout
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">
              <!--其他元素-->
         </LinearLayout>
   </androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
  ```

+ 方法属性

  + setRefreshing:设置显示/隐藏
  + setOnRefreshListener:监听下拉事件
  + setColorSchemeResources：设置多个颜色
  + setEnabled：设置是否可以滑动

## 23、测试网络接口-动态权限获取（上）

+ **Android 9.0 及以上  获取权限简述**

  + 网络权限声明

  ```xml
  //声明
  <uses-permission android:name="android.permission.INTERNET" />
  //配置application
  android:usesCleartextTraffic="true"
  //加入http
  <uses-library
   android:name="org.apache.http.legacy"
   android:required="true" />
  ```

  + 手机交互权限

  ```xml
  //声明
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
  ```

  弹出获取/动态获取

  ```java
  public static void  getPermissions(Activity activity){
      //判断sdk版本
      if (Build.VERSION.SDK_INT>=23) {
          //获取管理器
          int request= ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
          if (request!= PackageManager.PERMISSION_GRANTED)//如果缺少权限，进行权限申请
          {
              //准备缺少权限的集合,并准备一个回调id
              ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},20);
              return;//
          }
      }
  }
  ```

  activity回调是否获取

  ```java
  //获取权限监听
  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      switch (requestCode) {
          case 20:
              if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                      grantResults[1] == PackageManager.PERMISSION_GRANTED)) {
                  //同意了
              } else {
                  //拒绝权限
                  finish();
              }
              break;
      }
  }
  ```

  + 获取根目录

  ```java
  Environment.getExternalStorageDirectory()//--/storage/emulated/0/----这是sd卡的根目录
  getFilesDir().getAbsolutePath()//--/data/user/0/com.example.myapplication/files/--这是软件权限目录
  ```

  

## 24、测试网络接口-Vollery网络调用+gson解析json数据（下）

+ Vollery：调用接口

  + 测试接口：一言开放接口

  > https://v1.hitokoto.cn/

  + 简单版调用

  ```java
  RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
  queue.add(new JsonObjectRequest("https://api.uixsj.cn/hitokoto/get?type=hitokoto&code=json", new Response.Listener<JSONObject>() {
      @Override
      public void onResponse(JSONObject jsonObject) {
          Log.d("Toast",jsonObject.toString());
      }
  }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError volleyError) {
  
      }
  }));
  ```

  

  + 自定义包装为工具

    ```java
    final RequestQueue queue;
    public static void get( String path, final Context context, Response.Listener<JSONObject> res) {
        if(queue==null){
            queue  = Volley.newRequestQueue(context);
        }
    
        queue.add(new JsonObjectRequest(path, res, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
    
            }
        }));
    }
    ```

    

+ 解析接口

  + 插件：转为Class实体对象

    ```xml
    //    gson转换导入
    implementation 'com.google.code.gson:gson:2.8.5'
    ```

  + 软件插件：json转为Class实体对象

    > JsonFormat：快捷键alt+s

  + 解析成对象

  ```java
  Gson gson = new Gson();
  Object text = gson.fromJson(jsonObject.toString(), Object.class);
  ```

## 25、Activity、Fragment+ViewPager的常用生命周期

+ Activity

  + 简图

  <img src="F:\Typora_text\images\bil-android01.webp" alt="12239817-57bb34bbf201853d"  />

  + onCreate：入口
  + onStart：渲染
  + onResume：渲染数据
  + onRestart：重复渲染界面
  + onPause：页面显示完成
  + onStop：隐藏/离开界面
  + onDestroy:销毁界面

+ Fragment

  + 简图

    <img src="F:\Typora_text\images\bil-android02.webp" alt="6674027-a2ae1a9943c537ae"  />

  + 以上方法相似

  + ...

  + setUserVisibleHint：切换可见监听

    ```java
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            //当前页面可见
            Log.d("TestLog","可见");
        }else {
            //滑动并不可见了
            Log.d("TestLog","不可见");
        }
    }
    ```

    > 注意：
    >
    > + 不能开启懒路由

## 26、交互对话框 Toast、Dialog、下弹框的使用

+ Toast:提示框

  + setDuration：显示时间
  + setGravity：显示位置
  + setText：显示文字

+ AlertDialog：对话框

  + 简单使用

  ```java
  new AlertDialog.Builder(ViewPagerTest.this)
      			.setCancelable(false)	//是否可以主动取消
                  .setTitle("标题")
                  .setIcon(R.mipmap.ic_launcher)
                  .setMessage("内容")
                  .show();
  
  ```

  > 注意：上下文不能乱给

  + 属性方法
    + cancel：消失

  + 自定义显示View

  ```java
  View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout,null);
  //setView:填入
  ```

+ 三方插件下弹框：BottomSheetDialog

  + 推荐简书

  > https://www.jianshu.com/p/859943121b05

  + 导入

  ```xml
  //底部对话框
  implementation 'com.github.rey5137:material:1.2.5'
  ```

  + 使用

  ```java
  BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getApplicationContext());
  bottomSheetDialog
      .contentView(view)
      .inDuration(100)
      .outDuration(100)
      .cancelable(true)
      .show();
  ```

  > 注意：上下文不能乱给

## 27、Animation动画、属性动画（上）

+ 动画

  + 帧动画:连续的播放每一帧的图片

    + 准备图片资源
    + 准备帧动画资源:在drawable文件中创建即可

    ```xml
    <animation-list xmlns:android="http://schemas.android.com/apk/res/android">
        <item
            android:drawable="@drawable/listimage01"
            android:duration="100"/>
        <item
            android:drawable="@drawable/listimage02"
            android:duration="100"/>
        <item
            android:drawable="@drawable/listimage03"
            android:duration="100"/>
        <item
            android:drawable="@drawable/listimage04"
            android:duration="100"/>
    </animation-list>
    ```

    + 给图片作为背景
    + 获取背景并播放

    ```java
    ImageView imageView = findViewById(R.id.test);
    //获取背景，并将其强转成AnimationDrawable
    AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
    //判断是否在运行
    if(!animationDrawable.isRunning()){
        //开启帧动画
        animationDrawable.start();
    }
    ```

  + 补间动画

    + 创建动画文件包:**anim**

    + 准备动画资源文件（注意名字不能大写）

      + 使用动画

      ```java
      Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
      test.startAnimation(animation);
      ```

      + translate：平移动画

        ```xml
        <translate
            xmlns:android="http://schemas.android.com/apk/res/android"
            android:fromXDelta="0%"	
            android:fromYDelta="0%"
            android:toXDelta="50%"
            android:toYDelta="0%"
            android:duration="1000"
            >
        
        </translate>
        ```

        > + fromXDelta：起始X轴位置
        >
        > + fromYDelta：起始Y轴位置
        >
        >   > + toXDelta：到X的位置
        >   > + toYDelta：到Y的位置
        >   > + duration：中间动画的时间（注意这个不提示，需要手写）
        >   > + 注意：这里通常使用%计算单位，面向与父容器的宽高

  + scale：缩放动画

  ```xml
  <scale android:fromXScale="100%"
         android:fromYScale="0%"
         android:toXScale="80%"
         android:toYScale="80%"
         android:pivotY="50%"
         android:pivotX="50%"
         android:duration="1000"
         xmlns:android="http://schemas.android.com/apk/res/android" />
  ```

  > + fromXScale：初始X大小
  > + toXScale：缩小后的X大小
  > + pivotX、pivotY：X、Y的中心点

  + rotate：旋转动画

  ```xml
  <rotate android:fromDegrees="0"
                android:toDegrees="360"
                android:pivotX="50%"
                android:pivotY="50%"
        		android:duration="4000"
            xmlns:android="http://schemas.android.com/apk/res/android" />
  ```

  > + fromDegrees：初始角度
  > + toDegrees：旋转后角度

  > > + pivotX、pivotY：X、Y的中心点

  + alpha：透明度动画

  ```xml
  <alpha android:fromAlpha="0"
            android:toAlpha="1"
            android:duration="3000"
            xmlns:android="http://schemas.android.com/apk/res/android" />
  ```

  > + fromAlpha：初始透明度

  > + toAlpha：最后透明度

        > + 注意：这里范围是:0.0-1.0

+ 属性动画

  + 方法一:

    + 属性动画简述

      + 以动画的形式改变像素位置
      + 动画结束后组件固定位置

    + 简单使用

      ```java
      final ValueAnimator animator;
      animator = ValueAnimator.ofInt(0,330);
      animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator valueAnimator) {
              //获取当前的height值
              //动态更新view的高度
              mBt.getLayoutParams().height = (int) (Integer)animator.getAnimatedValue();
              mBt.requestLayout();
          }
      });
      animator.setDuration(1000);
      animator.start();
      ```

      > + 通过ValueAnimator获取动态值
      > + 通过动态值，改变组件的物理高度
      > + 注意：这里的单位是一致的

  + 方法二:

  ```java
  ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f,2f);
  ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageView, "scaleY", 2f,1f);
  objectAnimatorX.setDuration(1000);
  objectAnimatorY.setDuration(1000);
  objectAnimatorX.start();
  objectAnimatorY.start();
  ```

  

## 28、Animation动画、属性动画（下）


  + 技巧动画


      + listView子级动画
    
      + 创建一个子级的组合动画: list_item_set_anim.xml
    
        ```xml
        <set xmlns:android="http://schemas.android.com/apk/res/android">
            <translate
                       android:fromXDelta="10%"
                       android:toXDelta="0%"
                       android:duration="500"/>
            <alpha
                   android:fromAlpha="0.6"
                   android:toAlpha="1"
                   android:duration="500"/>
        </set>
        ```
    
        + 创建一个layoutAnimation父级动画:list_anim.xml
    
        ```xml
        <layoutAnimation android:animation="@anim/list_item_set_anim"
                         android:animationOrder="normal"
                         android:delay="0.5"
                         xmlns:android="http://schemas.android.com/apk/res/android">
        
        </layoutAnimation>
        ```
    
         > + animationOrder:子级显示模式
         >     >   + normal：按顺序
         >     >   + reverse：倒序
         >     >   + random：随机
         >     >   + delay:每个子级间隔
         >     >   + animation：子集动画
    
        + 最后给listView使用
    
        ```xml
        android:layoutAnimation="@anim/list_anim"
        ```
    
    + 跳转Activit使用动画
    
    ```java
    Intent intent = new Intent();
    intent.setClass(getApplicationContext(),Activity.class);
    startActivity(intent);
    overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
    ```
    
      > 注意：
      >
      > + overridePendingTransition方法一定在startActivity后面
      > + overridePendingTransition：参数1：当前页面消失动画，参数2：下个页面进入动画
    
    + 普通模板跳转
    + 跳转页面
    
    ```java
    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(ButtonTest.this).toBundle());
    ```
    
    > 这个是默认自带的一个跳转
    
    + 设置接收动画
    
    ```java
     getWindow().setEnterTransition(new Explode());//需要接收动画
    ```
    
    > 在跳转的界面接受即可

+ *共享元素跳转

  + 跳转界面

  ```java
  startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(
      ButtonTest.this, Pair.<View, String>create(mBt,"btn-image")).toBundle()
               );
  ```

  > + 同样使用ActivityOptions
  > + Pair：添加共享元素的集合即可:==一个组件和一个共享名==
  > + 最后.toBundel()

  + 设置接受动画的组件

  ```xml
  android:transitionName="image"
  ```

  > 接受的组件的共享名

## 29、Media媒体播放音乐、视频

+ 音乐

  + 播放本地资源

    + 软件资源

    ```java
    MediaPlayer.create(AnimationTest.this, R.raw.test);
    ```

    + sd资源

    ```java
    try {
        mediaPlayer.setDataSource("../music/samsara.mp3") ;
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

  + 播放网络资源

    ```java
    mMediaPlayer.setDataSource("http://..../xxx.mp3") ;
    ```

    > + 使用异步：prepareAsync
    > + 并缓存完成才能播放：setOnPreparedListener

+ 设置

  + 需使用异步缓冲

  ```java
   mMediaPlayer.prepareAsync() ;
  ```

  + 缓存完成后

  ```java
  setOnPreparedListener
  ```

  + 监听缓存进度+

  ```java
  setOnBufferingUpdateListener
  ```

  + 播放完成后

  ```java
  setOnCompletionListener
  ```

  + 获取当前进度

  ```java
  mediaPlayer.getCurrentPosition();
  ```

  + 获取总播放进度：帧

  ```java
  mediaPlayer.getDuration()
  ```

  + 设置进度

  ```java
  mediaPlayer.seekTo()
  ```

  + 暂停

  ```java
   mediaPlayer.pause();
  ```

  + 继续/播放

  ```java
   mediaPlayer.start();
  ```

  + 停止

  ```java
   mediaPlayer.stop();
  ```

+ 视频

  + 设置资源

    + sd资源

    ```java
    setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test_mp4));
    ```

    + 静态资源

    ```java
    setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.test_mp4);
    ```

  + 播放网络视频

  ```java
  videoView.setVideoPath("https:/...");
  ```

  > + 并缓存完成才能播放：setOnPreparedListener

  + 设置

    + 绑定进度条

    ```java
    //设置进度条
    MediaController mc = new MediaController(AnimationTest.this);  //注意上下文
    videoView.setMediaController(mc);
    ```

    + 缓存完成

    ```java
    setOnPreparedListener
    ```

    + 播放结束

    ```java
    setOnCompletionListener
    ```

    + 设置进度

    ```java
    seekTo
    ```

    + 使用相似...

+ 推荐三方播放插件

  + 哔哩哔哩开源:ijkplayer

## 30、SensorManager传感器的使用（隐式跳转）（上）

+ 推荐网站

> https://blog.csdn.net/weixin_38379772/article/details/79069494

+ 初始化

```java
SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);//获取传感器管理器
//创建一个SensorManager来获取系统的传感器服务
SensorManager  sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
```

+ 继承接口并实现方法

```java
	implements SensorEventListener{}
```

```java
  @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //监听回调
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
```



+ 获取手机支持的所有传感器

```java
List<Sensor> sensorList;
// 实例化传感器管理者

// 得到设置支持的所有传感器的List
sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
for (Sensor sensor : sensorList) {
    Log.d("FDFDS", "onResume: " + sensor.getName());
}
```

+ 重力感应

  + 注册传感器

  ```java
  //注册传感器
  sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_GRAVITY), SensorManager.SENSOR_DELAY_NORMAL);
  ```

  + 监听判断

  ```java
  if(sensorEvent.sensor.getType() == Sensor.TYPE_GRAVITY) {
      float X = sensorEvent.values[0];
      float Y = sensorEvent.values[1];
      float Z = sensorEvent.values[2];
      Log.d("FDFDS","x方向的重力加速度\n" + X);
      Log.d("FDFDS","Y方向的重力加速度\n" + Y);
      Log.d("FDFDS","Z方向的重力加速度\n" + Z);
  }
  ```

  > 就是把重力加速度分解到xyz三个方向上

  

+ 光照感应器

  + 注册传感器

  ```java
  // 为光传感器注册监听器
  sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);
  ```

  + 监听判断

  ```java
  if(sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){
      float X = sensorEvent.values[0];
      Log.d("FDFDS","光强度为为"+ X );
  }
  ```

  > 外部对手机的光照

+ 隐式跳转

  + 跳转电话

    ```java
    Intent Intent =  new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + "123123123"));//跳转到拨号界面，同时传递电话号码
    startActivity(Intent);
    ```

  + 跳转短信

    ```java
    //指定联系人
    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:我是指定联系人"));
    intent.putExtra("sms_body", "内容");
    startActivity(intent);
    ```

  + 跳转相机

    + 申请权限

    ```java
    <!--拍照-->
    <uses-permission android:name="android.permission.CAMERA" />
    ```

    + 动态获取权限...
    + 隐式跳转

    ```java
    //跳转相机
    private void toCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  //跳转到 ACTION_IMAGE_CAPTURE
        //判断内存卡是否可用，可用的话就进行存储
        //putExtra：取值，Uri.fromFile：传一个拍照所得到的文件，fileImg.jpg：文件名
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"fileImg.jpg")));
        startActivityForResult(intent,101); // 101: 相机的返回码参数（随便一个值就行，只要不冲突就好）
    }
    ```

    + 6.0以上版本闪退问题

    ```java
    //跳转相机动态权限
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }
    ```

## 31、SensorManager传感器的使用（指纹+NFC）（下）

+ 系统指纹识别

  + 推荐网站:https://www.jb51.net/article/92042.htm
  + 初始化

  ```java
  FingerprintManager manager;
  KeyguardManager mKeyManager;
  private final static int REQUEST_CODE_CONFIRM_DEVICE_CREDENTIALS = 0;
  private final static String TAG = "finger_log";
  manager = (FingerprintManager) this.getSystemService(Context.FINGERPRINT_SERVICE);
  mKeyManager = (KeyguardManager) this.getSystemService(Context.KEYGUARD_SERVICE);
  ```

  + 识别代码

  ```java
  @RequiresApi(api = Build.VERSION_CODES.M)
  public boolean isFinger() {
  
      //android studio 上，没有这个会报错 
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
          Toast.makeText(this, "没有指纹识别权限", Toast.LENGTH_SHORT).show();
          return false;
      }
      Log(TAG, "有指纹权限");
      //判断硬件是否支持指纹识别 
      if (!manager.isHardwareDetected()) {
          Toast.makeText(this, "没有指纹识别模块", Toast.LENGTH_SHORT).show();
          return false;
      }
      Log(TAG, "有指纹模块");
      //判断 是否开启锁屏密码 
  
      if (!mKeyManager.isKeyguardSecure()) {
          Toast.makeText(this, "没有开启锁屏密码", Toast.LENGTH_SHORT).show();
          return false;
      }
      Log(TAG, "已开启锁屏密码");
      //判断是否有指纹录入 
      if (!manager.hasEnrolledFingerprints()) {
          Toast.makeText(this, "没有录入指纹", Toast.LENGTH_SHORT).show();
          return false;
      }
      Log(TAG, "已录入指纹");
  
      return true;
  }
  
  CancellationSignal mCancellationSignal = new CancellationSignal();
  //回调方法 
  FingerprintManager.AuthenticationCallback mSelfCancelled = new FingerprintManager.AuthenticationCallback() {
      @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
      @Override
      public void onAuthenticationError(int errorCode, CharSequence errString) {
          //但多次指纹密码验证错误后，进入此方法；并且，不能短时间内调用指纹验证 
          Toast.makeText(MediaTest.this, errString, Toast.LENGTH_SHORT).show();
          showAuthenticationScreen();
      }
  
      @Override
      public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
  
          Toast.makeText(MediaTest.this, helpString, Toast.LENGTH_SHORT).show();
      }
  
      @Override
      public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
  
          Toast.makeText(MediaTest.this, "指纹识别成功", Toast.LENGTH_SHORT).show();
      }
  
      @Override
      public void onAuthenticationFailed() {
          Toast.makeText(MediaTest.this, "指纹识别失败", Toast.LENGTH_SHORT).show();
      }
  };
  
  
  @RequiresApi(api = Build.VERSION_CODES.M)
  public void startListening(FingerprintManager.CryptoObject cryptoObject) {
      //android studio 上，没有这个会报错 
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
          Toast.makeText(this, "没有指纹识别权限", Toast.LENGTH_SHORT).show();
          return;
      }
      manager.authenticate(cryptoObject, mCancellationSignal, 0, mSelfCancelled, null);
  
  
  }
  
  /**
       * 锁屏密码 
       */
  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  private void showAuthenticationScreen() {
  
      Intent intent = mKeyManager.createConfirmDeviceCredentialIntent("finger", "测试指纹识别");
      if (intent != null) {
          startActivityForResult(intent, REQUEST_CODE_CONFIRM_DEVICE_CREDENTIALS);
      }
  }
  
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (requestCode == REQUEST_CODE_CONFIRM_DEVICE_CREDENTIALS) {
          // Challenge completed, proceed with using cipher 
          if (resultCode == RESULT_OK) {
              Toast.makeText(this, "识别成功", Toast.LENGTH_SHORT).show();
          } else {
              Toast.makeText(this, "识别失败", Toast.LENGTH_SHORT).show();
          }
      }
  }
  
  private void Log(String tag, String msg) {
      Log.d(tag, msg);
  }
  ```

  + 最后判断使用

  ```java
  if (isFinger()) {
      Toast.makeText(MediaTest.this, "请进行指纹识别", Toast.LENGTH_LONG).show();
      startListening(null);
  }
  ```

+ NFC感应使用

  + 申请权限

  ```xml
  <uses-feature
                android:name="android.hardware.nfc"
                android:required="true" />
  <uses-permission android:name="android.permission.NFC" />
  ```

  + 动态申请权限...

  + 准备一个NFC的工具类

  ```java
  public class NfcUtils {
      //nfc
      public  NfcAdapter mNfcAdapter;
      public static IntentFilter[] mIntentFilter = null;
      public static PendingIntent mPendingIntent = null;
      public static String[][] mTechList = null;
  
      public NfcUtils(Activity activity) {
          mNfcAdapter = NfcCheck(activity);
          NfcInit(activity);
      }
  
      /**
       * 检查NFC是否打开
       */
      public static NfcAdapter NfcCheck(Activity activity) {
          NfcAdapter mNfcAdapter = NfcAdapter.getDefaultAdapter(activity);
          if (mNfcAdapter == null) {
              Toast.makeText(activity, "设备不支持NFC功能!", Toast.LENGTH_SHORT).show();
              return null;
          } else {
              if (!mNfcAdapter.isEnabled()) {
                  IsToSet(activity);
              } else {
                  Toast.makeText(activity, "NFC功能已打开!", Toast.LENGTH_SHORT).show();
              }
          }
          return mNfcAdapter;
      }
  
      /**
       * 初始化nfc设置
       */
      public static void NfcInit(Activity activity) {
          Intent intent = new Intent(activity, activity.getClass());
          intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
          mPendingIntent = PendingIntent.getActivity(activity, 0, intent, 0);
          //做一个IntentFilter过滤你想要的action 这里过滤的是ndef
          IntentFilter filter = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
          //如果你对action的定义有更高的要求，比如data的要求，你可以使用如下的代码来定义intentFilter
          //        IntentFilter filter2 = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
          //        try {
          //            filter.addDataType("*/*");
          //        } catch (IntentFilter.MalformedMimeTypeException e) {
          //            e.printStackTrace();
          //        }
          //        mIntentFilter = new IntentFilter[]{filter, filter2};
          //        mTechList = null;
          try {
              filter.addDataType("*/*");
          } catch (IntentFilter.MalformedMimeTypeException e) {
              e.printStackTrace();
          }
          mTechList = new String[][]{{MifareClassic.class.getName()},
                  {NfcA.class.getName()}};
          //生成intentFilter
          mIntentFilter = new IntentFilter[]{filter};
      }
  
  
      /**
       * 读取NFC的数据
       */
      public static String readNFCFromTag(Intent intent) throws UnsupportedEncodingException {
          Parcelable[] rawArray = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
          if (rawArray != null) {
              NdefMessage mNdefMsg = (NdefMessage) rawArray[0];
              NdefRecord mNdefRecord = mNdefMsg.getRecords()[0];
              if (mNdefRecord != null) {
                  String readResult = new String(mNdefRecord.getPayload(), "UTF-8");
                  return readResult;
              }
          }
          return "";
      }
  
  
      /**
       * 往nfc写入数据
       */
      public static void writeNFCToTag(String data, Intent intent) throws IOException, FormatException {
          Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
          Ndef ndef = Ndef.get(tag);
          ndef.connect();
          NdefRecord ndefRecord = null;
          if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
              ndefRecord = NdefRecord.createTextRecord(null, data);
          }
          NdefRecord[] records = {ndefRecord};
          NdefMessage ndefMessage = new NdefMessage(records);
          ndef.writeNdefMessage(ndefMessage);
      }
  
      /**
       * 读取nfcID
       */
      public static String readNFCId(Intent intent) throws UnsupportedEncodingException {
          Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
          String id = ByteArrayToHexString(tag.getId());
          return id;
      }
  
      /**
       * 将字节数组转换为字符串
       */
      private static String ByteArrayToHexString(byte[] inarray) {
          int i, j, in;
          String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
          String out = "";
  
          for (j = 0; j < inarray.length; ++j) {
              in = (int) inarray[j] & 0xff;
              i = (in >> 4) & 0x0f;
              out += hex[i];
              i = in & 0x0f;
              out += hex[i];
          }
          return out;
      }
  
      private static void IsToSet(final Activity activity) {
          AlertDialog.Builder builder = new AlertDialog.Builder(activity);
          builder.setMessage("是否跳转到设置页面打开NFC功能");
  //        builder.setTitle("提示");
          builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  goToSet(activity);
                  dialog.dismiss();
              }
          });
          builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          });
          builder.create().show();
      }
  
      private static void goToSet(Activity activity) {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
              // 进入设置系统应用权限界面
              Intent intent = new Intent(Settings.ACTION_SETTINGS);
              activity.startActivity(intent);
              return;
          } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 运行系统在5.x环境使用
              // 进入设置系统应用权限界面
              Intent intent = new Intent(Settings.ACTION_SETTINGS);
              activity.startActivity(intent);
              return;
          }
      }
  }
  ```

  + 初始化

  ```java
   NfcUtils  nfcUtils = new NfcUtils(this);
  ```

  + 检测是否拥有/开启nfc

  ```java
  //设定intentfilter和tech-list。如果两个都为null就代表优先接收任何形式的TAG action。也就是说系统会主动发TAG intent。
  if (nfcUtils.mNfcAdapter != null) {
      nfcUtils.mNfcAdapter.enableForegroundDispatch(this, NfcUtils.mPendingIntent, NfcUtils.mIntentFilter, NfcUtils.mTechList);
  }else {
      Toast.makeText(this, "调用失败", Toast.LENGTH_SHORT).show();
  }
  ```

  > 一般在生命周期的onResume方法中判断

  + 优化清空缓存

  ```java
  @Override
  protected void onDestroy() {
      super.onDestroy();
      nfcUtils.mNfcAdapter = null;
  }
  @Override
  protected void onPause() {
      super.onPause();
      if (nfcUtils.mNfcAdapter != null) {
          nfcUtils.mNfcAdapter.disableForegroundDispatch(this);
      }
  }
  ```

  + 传感回调

  ```java
  //在onNewIntent中处理由NFC设备传递过来的intent
  @Override
  protected void onNewIntent(Intent intent) {
      super.onNewIntent(intent);
      Log.e(TAG, "--------------NFC-------------" );
      processIntent(intent);
  }
  ```

  + 获取数据

  ```java
  //  这块的processIntent() 就是处理卡中数据的方法
  public void processIntent(Intent intent) {
      Parcelable[] rawmsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);//获取数据
      Toast.makeText(this, "读取成功!", Toast.LENGTH_SHORT).show();
  }
  ```


## 32、Service服务+广播的简单使用（理解）（上）

+ 理解service和广播
  + 四大组件之一
    + activity（活动/界面）
    + service（服务）
    + Broadcast Receive（广播）
    + Content Provider（内容提供者）
  + 可以比作为线程的逻辑
  + 服务与全软件界面
  + 广播发送全软件界面
+ 构造

```java
package com.example.t_world.service;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyService extends Service {

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(BasDataUtil.LOG_TOAST, "服务销毁;");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(BasDataUtil.LOG_TOAST, "服务创建----Create");
    }

    public MyService() {
        Log.d(BasDataUtil.LOG_TOAST, "实例化MyService服务");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(BasDataUtil.LOG_TOAST, "服务----绑定成功");
        // TODO: Return the communication channel to the service.
        //返回到服务的通信通道。
        return new PlayMusicBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            String activityKey = intent.getStringExtra("data");
            if (activityKey!=null){
             //intent传入的参数接收
            }
        }catch (Exception e){
            Log.d(BasDataUtil.LOG_TOAST,"播放音乐服务--发广播/收广播错误:"+e.toString());
        }

        return super.onStartCommand(intent, flags, startId);
    }
    
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(BasDataUtil.LOG_TOAST, "解绑MyService成功");
        return super.onUnbind(intent);
    }
}
```

> 注意:
>
> + 启动服务调用的是onCreate
>
> + 关闭服务调用的是:onDestroy
>
> + 绑定服务调用的是onBind
>
> + 取消绑定调用的是:onUnbind
>
> + intent传参数跳转服务，需要接收使用:onStartCommand
>
>   ```java
>   Intent intent = new Intent(this, MyService.class);  
>   startService(intent);
>   ```

## 33、service服务+广播的简单使用（交互）（下）

+ **服务(Service)向外互动**

  + 发送广播

    + **服务准备代码**

    ```java
    private LocalBroadcastManager localBroadcastManager;	//准备发送广播控制器
    @Override
    public void onCreate() {
        localBroadcastManager = LocalBroadcastManager.getInstance(this);	//实例化
        super.onCreate();
        Log.d(BasDataUtil.LOG_TOAST, "服务----Create");
    }
    //--------发送广播
    Intent intent = new Intent("com.example.Service");	//准备一个intent：并实例一个标识:可使用自己的包名
    intent.putExtra("dataKey", "dataKey的值");//需要传入的参数
    localBroadcastManager.sendBroadcast(intent);	//使用广播发送器发送
    ```

    + **接收广播**

    ```java
    private LocalReceiver localReceiver;
    private IntentFilter intentFilter;
    ///--提供广播监听
    //监听广播
    class LocalReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            try {
                String dataKey = intent.getStringExtra("dataKey");
                //判定获取是否成功
            }catch (Exception e){
                Log.d(BasDataUtil.LOG_TOAST,"播放接收广播错误："+e.toString());
            }
    
        }
    }
    //--在该页注册广播
    @Override
    protected void onStart() {
        //注册本地广播监听器
        intentFilter = new IntentFilter();	//实例
        intentFilter.addAction("com.example.Service");//绑定标识
        localReceiver = new LocalReceiver();	//实例
        //广播
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(PlayListActivity.this);//通过getInstance()得到LocalBroadcastManager的实例;
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);//启动广播接收
        super.onStart();
    }
    
    
    ```

+ **页面向服务(Service)交互**

  + ​	绑定服务，就可以交互 

    + Service准备代码

    ```java
    //准备一个给页面调用的类
    class PlayMusicBinder extends Binder {//例如这里可以直接播放，暂停，继续...各种操作
    
        public PlayMusicBinder() {
            //初始化控制器
            mediaPlayer = new MediaPlayer();
    
        }
    	public String  getData(){
            return "这是服务中的方法";
        }
    
    }
    //准备一个IBinder，与页面交互:绑定立马调用
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(BasDataUtil.LOG_TOAST, "服务----绑定成功");
        // TODO: Return the communication channel to the service.
        return new PlayMusicBinder();	//返回服务中的Binder类
    }
    
    ```

    + 页面绑定服务(Service)并，使用服务的方法

    ```java
    PlayMusicBinder playMusicBinder;
    //--准备一个接收服务管理器:绑定后直接调用
    private ServiceConnection connection = new ServiceConnection() {
        /**
             * 连接到服务
             * @param name
             * @param service
             */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //连接服务成功
            playMusicBinder = (PlayMusicBinder) service;//这里就直接获取了playMusicBinder控制
        }
    
        /**
             * 断开连接
             * @param name
             */
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };
    //--绑定服务
    @Override
    protected void onStart() {
        //        绑定服务
        bindService(new Intent(getApplicationContext(), AudioService.class), connection, Service.BIND_AUTO_CREATE);
        super.onStart();
    }
    //---这个时候就可以直接使用了
    playMusicBinder.getData();
    ```


## 34、Android中的数据存储/传输（本地数据)（上)

+ 变量

```java
int i;
String s;
```

> 使用范围：当前代码块

+ 全局变量

```java
public static int i;
public static String s;
```

> 使用范围：跨类可以使用

+ **跳转界面传入数据**

  + 传入基础数据

    + 跳转传入数据

    ```java
    Intent intent  =new Intent(getApplicationContext(), Activity2.class);
    intent.putExtra("key01","value01");
    startActivity(intent);
    ```

    + 接受传入的数据

    ```java
    Intent intent= getIntent();
    Log.d(BaseData.LOG_TOAST,intent.getStringExtra("key01"));
    ```

    > 这里注意获取可能为null 

  + 传入对象

    + 准备一个对象类

    ```java
    public class User implements Serializable {
        String name;
        int id;
        ...
    ```

    > 该类需要继承 implements Serializable ，才能被存入

    + 跳转传入数据

    ```java
    Intent intent  =new Intent(getApplicationContext(), ServiceTset2.class);
    User user = new User("12",1);
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", user);
    intent.putExtras(bundle);
    startActivity(intent);
    ```

    > 注意：
    >
    > + 这里使用Bundle来存入数据，使用方法和intent类似
    > + 它相当于一个集合

    + 接受传入的数据

    ```java
    Bundle intent= getIntent().getExtras();
    User user= (User) intent.get("user");
    Log.d(BaseData.LOG_TOAST,user.toString());
    ```

    > 使用Bundle设置就得使用Bundle接受

+ **使用SharedPreferences实现本地储存**

  > 使用范围：全软件,并与软件共存（因为它存在软件里的文件夹里(data/data/shared_perfs/文件名.xml)）

  + **初始化**

  ```java
  SharedPreferences sharedPreferences = getSharedPreferences("testSp",MODE_PRIVATE);
  SharedPreferences.Editor editor = sharedPreferences.edit();
  ```

  > + testSp：文件名.xml
  >
  > + 模式
  >   + MODE_PRIVATE:默认模式，**创建的文件只能由 调用的应用程序（或者共享相同用户ID的应用程序）访问**。
  > + sharedPreferences：用来读取文件中的键值
  > + editor：用于写入文件中的键值

  + **使用SharedPreferences**

    > 它的数据会一直保存只能自己删除或卸载软件

    + **存入/更新**

    ```java
    editor.putString("key","testKey");
    editor.apply();
    ```

    + 删除

    ```java
    editor.remove("key");//根据键删除
    editor.clear();//清空
    ```

    

## 35、Android中的数据存储/传输（Sqlite)（下)

+ 数据库的概率

  + 可以拿表格办公软件理解
  + 一个数据库包含多个表格
  + 一个表格包含多个属性
  + 一个属性有多个数据

+ 简单使用**SQLiteOpenHelper**

  + 首先准备一个Helpter的实例类(**创建的数据库文件：data/data/软件软件/databases/数据库名.db**)

  ```java
  public class SqlitHelper extends SQLiteOpenHelper {
      private static  String SQL_NAME = "testSql.db";
      private static int  SQL_VERSION = 1;
      public SqlitHelper(@Nullable Context context) {
          super(context, SQL_NAME, null, SQL_VERSION);
      }
  
      //注意这个方法只执行一次，所以在这创建表格
      @Override
      public void onCreate(SQLiteDatabase db) {
          String sql = "create table tb_user(name varchar(20),pwd varchar(20))";
          db.execSQL(sql);
      }
      //注意这个是数据库更新才调用
      @Override
      public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
  
      }
  }
  ```

  > 注意：
  >
  > + 这个可以当成模板，不需要死记
  > + onCreate：注意这个方法只执行一次，所以在这创建表格

  + 数据库的查删修

    + 插入

    ```java
    SqlitHelper sqlitHelper = new SqlitHelper(this);
    SQLiteDatabase db = sqlitHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("name","张三");
    values.put("pwd","123");
    db.insert("tb_user",null,values);
    ```

    + 查询

    ```java
    SqlitHelper sqlitHelper = new SqlitHelper(this);
    SQLiteDatabase db = sqlitHelper.getWritableDatabase();
    //创建游标对象
    Cursor cursor = db.query("tb_user", new String[]{"name","pwd"}, null, null, null, null, null);
    //利用游标遍历所有数据对象
    while(cursor.moveToNext()){
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
        Log.d(BaseData.LOG_TOAST,"数据库:"+name+","+pwd);
    }
    ```

    + 删除：db.delete()...

+ **使用Ormlite插件调用sqlite数据库**

  + 减少了sql语句操作

  + 增加了对类的面向对象

  + 简单使用

    + 准备一个数据库的实体类

    ```java
    @DatabaseTable(tableName = "tb_user2")//创建表名
    public class UserEntity implements Serializable {
        @DatabaseField()
        String name;
        @DatabaseField()
        String pwd;
        @DatabaseField()
        String age;
    ...
    ```

    > 注意：
    >
    > + DatabaseTable：注释写法，说明这个类对应表格名
    > + DatabaseField：这个属性就是一个键
    >
    > + 其他写法
    >
    > ```
    > @ DatabaseField注解可以有以下字段：
    > 
    > columnName 列名，未指定时为字段名
    > dataType DataType类的类型的字段。通常的类型是从Java类的领域，并不需要指定。
    > defaultValue 默认值
    > width 宽度 默认是0，表示不限
    > canBeNull 是否允许为空，默认为true
    > id 主键 默认为false
    > generatedId 自增长的主键 默认值是false
    > generatedIdSequence 字符串名称的序列号 类同generatedId，但您可以指定序列的名称使用。默认为null
    > foreign 外键，默认为false,字段不能是一个原始类型。在外键对象的类中，必须要有一个ID字段（ID， generatedId，generatedIdSequence）
    > useGetSet 应用get和set方法访问。默认为false
    > unknownEnumName 表示该字段是一个Java的枚举类型
    > throwIfNull 如果为空值，抛出一个异常 默认为false
    > persisted 是否在数据库中存储这个领域 默认为true
    > format 指定某一特定领域的信息格式,如指定日期字符串的格式
    > unique 唯一约束，默认为false
    > uniqueCombo 唯一行，该行内所有字段成为一个唯一约束，如有firstName 和 lastName两个字段，为"张"和"梅"，那么该表内不可再插             入"张"，"梅"，   但你可插入"张"，"全梅"。
    > index 是否建立索引 默认为false
    > uniqueIndex 唯一索引 默认为false
    > indexName 为这一领域的索引添加一个名字
    > uniqueIndexName 为这一领域的索引添加一个唯一的名字
    > foreignAutoRefresh 当查询到一个外键对象时，是否自动刷新 如 Order表中有Account外键对象，当返回Order的记录时是否也返回Account的记录，           默认为false
    > maxForeignAutoRefreshLevel 为了防止无限递归或者无限循环时 需要用到该属性设置自动刷新的最高级别
    > allowGeneratedIdInsert 插入一个ID字段是否覆盖它生成的ID的对象 默认为false
    > columnDefinition 定义列，默认情况下，数据库类型是用于自动生成所需的SQL来创建列，所以该属性并不常用
    > foreignAutoCreate 在插入一个有外键对象的对象时，是否自动插入这个外键对象
    > version 行版本 当一个对象被更新，以防止数据损坏多个实体时更新在同一时间进行的保护
    > ```

    + 实例**OrmLiteSqliteOpenHelper**

    ```java
    public class SqlitOrmHelper extends OrmLiteSqliteOpenHelper {
        private static String SQL_NAME = "testSql.db";
        private static int SQL_VERSION = 1;
    
        public SqlitOrmHelper(Context context) {
            super(context, SQL_NAME, null, SQL_VERSION);
        }
    
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
           //创建表格
            try {
                TableUtils.createTable(connectionSource, UserEntity.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
    
        }
    }
    ```

    + 查/删/改操作

      + 首先获取它自带的dao文件

      ```java
      SqlitOrmHelper sqlitOrmHelper = new SqlitOrmHelper(this);
      try {
          Dao<UserEntity, ?> dao = sqlitOrmHelper.getDao(UserEntity.class);
      }catch (SQLException e) {
          e.printStackTrace();
      }
      ```

+ 插入
      

```java
      Dao<UserEntity, ?> dao = sqlitOrmHelper.getDao(UserEntity.class);
      UserEntity userEntity = new UserEntity();
      userEntity.setName("张三orm");
      userEntity.setPwd("张三orm");
      userEntity.setAge("2");
      dao.create(userEntity);
```

+ 查询
      

```java
      List<UserEntity> userEntities = dao.queryForAll();
      Log.d(BaseData.LOG_TOAST,"查询成功："+userEntities.toString());
```

+ 删除:复杂操作
      

```java
      DeleteBuilder<UserEntity, ?> userEntityDeleteBuilder = dao.deleteBuilder();
      userEntityDeleteBuilder.where().eq("name","张三orm");
      userEntityDeleteBuilder.delete();
```

