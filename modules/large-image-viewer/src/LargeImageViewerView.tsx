import {requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { LargeImageViewerProps } from './LargeImageViewer.types';

const NativeLargeImageViewer = requireNativeViewManager('LargeImageViewer');

export default function LargeImageViewerView(props: LargeImageViewerProps) {
  return <NativeLargeImageViewer {...props} />;
}
