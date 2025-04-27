// Reexport the native module. On web, it will be resolved to LargeImageViewerModule.web.ts
// and on native platforms to LargeImageViewerModule.ts
export { default } from './src/LargeImageViewerModule';
export { default as LargeImageViewerView } from './src/LargeImageViewerView';
export * from  './src/LargeImageViewer.types';
