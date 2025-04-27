import * as React from 'react';
import { View, Text } from 'react-native';

export default function LargeImageViewerView() {
  React.useEffect(() => {
    console.warn('LargeImageViewer is not supported on web.');
  }, []);

  return (
    <View
      style={{
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: '#f0f0f0'
      }}
    >
      <Text style={{ color: '#333', fontSize: 16 }}>
        LargeImageViewer is not supported on web.
      </Text>
    </View>
  );
}
