import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Vítej ve Flutteru',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Vítej ve Flutteru'),
        ),
        body: Center(
          child: Text('Zkouška'),
        ),
      ),
    );
  }
}