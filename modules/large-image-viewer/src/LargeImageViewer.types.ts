import type { ViewProps } from 'react-native';

export interface AnimateCenter {
  x: number;
  y: number;
}

export interface AnimateScaleAndCenter {
  scale: number;
  center: AnimateCenter;
}

export interface LargeImageViewerProps extends ViewProps {
  source: string;
  zoomEnabled?: boolean;
  quickScaleEnabled?: boolean;
  minScale?: number;
  maxScale?: number;
  orientation?: number;
  panLimit?: number;
  minimumScaleType?: number;
  minimumDpi?: number;
  maximumDpi?: number;
  panEnabled?: boolean;
  eagerLoadingEnabled?: boolean;
  doubleTapZoomDpi?: number;
  doubleTapZoomDuration?: number;
  doubleTapZoomStyle?: number;
  animateScale?: number;
  animateCenter?: AnimateCenter;
  animateScaleAndCenter?: AnimateScaleAndCenter;

  // Events
  onLoadStart?: (event: LargeImageViewerEvent) => void;
  onLoad?: (event: LargeImageViewerLoadEvent) => void;
  onLoadError?: (event: LargeImageViewerEvent) => void;
  onScaleChanged?: (event: LargeImageViewerScaleEvent) => void;
  onCenterChanged?: (event: LargeImageViewerCenterEvent) => void;
}

export interface LargeImageViewerEvent {
  nativeEvent: Record<string, any>;
}

export interface LargeImageViewerLoadEvent {
  nativeEvent: {
    width: number;
    height: number;
  };
}

export interface LargeImageViewerScaleEvent {
  nativeEvent: {
    newScale: number;
    origin: number;
  };
}

export interface LargeImageViewerCenterEvent {
  nativeEvent: {
    x: number;
    y: number;
    origin: number;
  };
}
