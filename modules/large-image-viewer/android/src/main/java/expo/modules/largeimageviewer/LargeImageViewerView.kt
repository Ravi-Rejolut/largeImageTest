package expo.modules.largeimageviewer

import android.content.Context
import android.graphics.PointF
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.views.ExpoView

class LargeImageViewerView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
  private val onLoad by EventDispatcher()
  private val onLoadStart by EventDispatcher()
  private val onLoadError by EventDispatcher()
  private val onScaleChanged by EventDispatcher()
  private val onCenterChanged by EventDispatcher()

  internal val imageView = SubsamplingScaleImageView(context).apply {
    layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
  }

  init {
    addView(imageView)

    imageView.setOnImageEventListener(object : SubsamplingScaleImageView.OnImageEventListener {
      override fun onReady() {
        onLoad(mapOf(
          "width" to imageView.sWidth,
          "height" to imageView.sHeight
        ))
      }

      override fun onImageLoaded() {}
      override fun onPreviewLoadError(e: Exception?) {}
      override fun onImageLoadError(e: Exception?) {
        onLoadError(emptyMap())
      }
      override fun onTileLoadError(e: Exception?) {}
      override fun onPreviewReleased() {}
    })

    imageView.setOnStateChangedListener(object : SubsamplingScaleImageView.OnStateChangedListener {
      override fun onScaleChanged(newScale: Float, origin: Int) {
        onScaleChanged(mapOf(
          "newScale" to newScale,
          "origin" to origin
        ))
      }

      override fun onCenterChanged(newCenter: PointF, origin: Int) {
        onCenterChanged(mapOf(
          "x" to newCenter.x,
          "y" to newCenter.y,
          "origin" to origin
        ))
      }
    })
  }

  fun setImageUri(uri: String) {
    onLoadStart(emptyMap())
    imageView.setImage(ImageSource.uri(uri))
  }

  fun setZoomEnabled(enabled: Boolean) {
    imageView.setZoomEnabled(enabled)
  }

  fun setQuickScaleEnabled(enabled: Boolean) {
    imageView.setQuickScaleEnabled(enabled)
  }
  fun setMinScale(minScale: Float) {
    imageView.setMinScale(minScale)
  }

  fun setMaxScale(maxScale: Float) {
    imageView.setMaxScale(maxScale)
  }

  override fun setOrientation(orientation: Int) {
    imageView.setOrientation(orientation)
  }

  fun setPanLimit(panLimit: Int) {
    imageView.setPanLimit(panLimit)
  }

  fun setMinimumScaleType(scaleType: Int) {
    imageView.setMinimumScaleType(scaleType)
  }

  fun setMinimumDpi(dpi: Int) {
    imageView.setMinimumDpi(dpi)
  }

  fun setMaximumDpi(dpi: Int) {
    imageView.setMaximumDpi(dpi)
  }

  fun setPanEnabled(enabled: Boolean) {
    imageView.setPanEnabled(enabled)
  }

  fun setEagerLoadingEnabled(enabled: Boolean) {
    imageView.setEagerLoadingEnabled(enabled)
  }

  fun setDoubleTapZoomDpi(dpi: Int) {
    imageView.setDoubleTapZoomDpi(dpi)
  }

  fun setDoubleTapZoomDuration(duration: Int) {
    imageView.setDoubleTapZoomDuration(duration)
  }

  fun setDoubleTapZoomStyle(style: Int) {
    imageView.setDoubleTapZoomStyle(style)
  }

  fun animateScale(scale: Float) {
    imageView.animateScale(scale)
  }

  fun animateCenter(x: Float, y: Float) {
    imageView.animateCenter(PointF(x, y))
  }

  fun animateScaleAndCenter(scale: Float, x: Float, y: Float) {
    imageView.animateScaleAndCenter(scale, PointF(x, y))
  }
}
