import React from 'react';
import {SafeAreaView, ScrollView, Text, View} from 'react-native';

const App = (): JSX.Element => {
  return (
    <SafeAreaView>
      <ScrollView contentInsetAdjustmentBehavior="automatic">
        <View>
          <Text>Hola</Text>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default App;
