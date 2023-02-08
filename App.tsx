import React, {useEffect} from 'react';
import {SafeAreaView, ScrollView, Text, View} from 'react-native';
import MCReactModule from 'react-native-marketingcloudsdk';

const App = (): JSX.Element => {
  const updateRegistrationData = async () => {
    MCReactModule.setContactKey('jmiguel_guevara@outlook.com');
    const contactKey = await MCReactModule.getContactKey();
    const attrs = await MCReactModule.getAttributes();
    const tags = await MCReactModule.getTags();
    const systemToken = await MCReactModule.getSystemToken();
    const isPushEnabled = await MCReactModule.isPushEnabled();
    console.log('[APP]: contactKey: ', contactKey);
    console.log('[APP]: attrs: ', attrs);
    console.log('[APP]: tags: ', tags);
    console.log('[APP]: systemToken: ', systemToken);
    console.log('[APP]: isPushEnabled: ', isPushEnabled);
  };

  useEffect(() => {
    updateRegistrationData().catch(console.error);
  }, []);

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
