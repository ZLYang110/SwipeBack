# SwipeBack
SwipeBackLayout侧滑关闭页面

## 效果预览
![](https://github.com/ZLYang110/SwipeBack/tree/master/gif/1.gif)
## 使用方式
### build.gradle文件
```
implementation 'com.github.ZLYang110:SwipeBack:1.0.1'
```
### Activity继承SwipeBackActivity
```
public class MainActivity extends SwipeBackActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	...

    }
}
```
### 设置滑动关闭的方向
```
switch (checkedId){
                    case R.id.mode_left:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_LEFT);
                        break;
                    case R.id.mode_right:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_RIGHT);
                        break;
                    case R.id.mode_top:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_TOP);
                        break;
                    case R.id.mode_bottom:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_BOTTOM);
                        break;

                }
```

