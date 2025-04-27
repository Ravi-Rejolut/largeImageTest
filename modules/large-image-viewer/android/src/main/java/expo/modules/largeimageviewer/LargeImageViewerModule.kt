package expo.modules.largeimageviewer

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class LargeImageViewerModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("LargeImageViewer")

    Events(
      "onLoad",
      "onLoadStart",
      "onLoadError",
      "onScaleChanged",
      "onCenterChanged"
    )

    View(LargeImageViewerView::class) {
      Prop("source") { view, uri: String ->
        view.setImageUri(uri)
      }

      Prop("zoomEnabled") { view, enabled: Boolean ->
        view.setZoomEnabled(enabled)
      }

      Prop("quickScaleEnabled") { view, enabled: Boolean ->
        view.setQuickScaleEnabled(enabled)
      }

      Prop("minScale") { view, value: Float ->
        view.setMinScale(value)
      }

      Prop("maxScale") { view, value: Float ->
        view.setMaxScale(value)
      }

      Prop("orientation") { view, value: Int ->
        view.setOrientation(value)
      }

      Prop("panLimit") { view, value: Int ->
        view.setPanLimit(value)
      }

      Prop("minimumScaleType") { view, value: Int ->
        view.setMinimumScaleType(value)
      }

      Prop("minimumDpi") { view, value: Int ->
        view.setMinimumDpi(value)
      }

      Prop("maximumDpi") { view, value: Int ->
        view.setMaximumDpi(value)
      }

      Prop("panEnabled") { view, enabled: Boolean ->
        view.setPanEnabled(enabled)
      }

      Prop("eagerLoadingEnabled") { view, enabled: Boolean ->
        view.setEagerLoadingEnabled(enabled)
      }

      Prop("doubleTapZoomDpi") { view, value: Int ->
        view.setDoubleTapZoomDpi(value)
      }

      Prop("doubleTapZoomDuration") { view, value: Int ->
        view.setDoubleTapZoomDuration(value)
      }

      Prop("doubleTapZoomStyle") { view, value: Int ->
        view.setDoubleTapZoomStyle(value)
      }

      // Animate props
      Prop("animateScale") { view, scale: Float ->
        view.animateScale(scale)
      }

      Prop("animateCenter") { view, center: Map<String, Double> ->
        val x = center["x"]?.toFloat() ?: 0f
        val y = center["y"]?.toFloat() ?: 0f
        view.animateCenter(x, y)
      }

      Prop("animateScaleAndCenter") { view, options: Map<String, Any> ->
        val scale = (options["scale"] as? Double)?.toFloat() ?: 1f
        val center = options["center"] as? Map<*, *>
        if (center != null) {
          val x = (center["x"] as? Double)?.toFloat() ?: 0f
          val y = (center["y"] as? Double)?.toFloat() ?: 0f
          view.animateScaleAndCenter(scale, x, y)
        }
      }
    }

  }
}
