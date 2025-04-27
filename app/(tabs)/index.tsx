import { Image, StyleSheet, Platform, View, Text } from 'react-native';

import { HelloWave } from '@/components/HelloWave';
import ParallaxScrollView from '@/components/ParallaxScrollView';
import { ThemedText } from '@/components/ThemedText';
import { ThemedView } from '@/components/ThemedView';
import LargeImageViewerView from '@/modules/large-image-viewer/src/LargeImageViewerView.web';

export default function HomeScreen() {
  const handleLoad = () => {
    console.log("heello")
  }
  return (
    <>
      <View>
        <LargeImageViewerView
          source="https://raw.githubusercontent.com/Ravi-Rejolut/publicImages/refs/heads/main/c1-0.jpg"
          zoomEnabled
          minScale={1}
          maxScale={5}
          onLoad={(e) => console.log('Loaded with width:', e.nativeEvent.width)}
          onScaleChanged={(e) => console.log('Scale changed', e.nativeEvent.newScale)}
        />
      </View>
    </>
  );
}


