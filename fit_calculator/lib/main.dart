import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'FitCalculator',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primaryColor: Colors.teal[600],
      ),
      home: DropdownMenuDemo(),

    );
  }
}

class DropdownMenuDemo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('FitCalculator'),

        actions: [
          IconButton(icon: Icon(Icons.calendar_today), onPressed: (){}),
          PopupMenuButton(
            icon: Icon(Icons.more_vert),
            itemBuilder: (BuildContext context) => <PopupMenuEntry>[
              const PopupMenuItem(
                child: ListTile(
                  leading: Icon(Icons.add),
                  title: Text('Moje cvičistě'),
                ),
              ),
              const PopupMenuItem(
                child: ListTile(
                  leading: Icon(Icons.anchor),
                  title: Text('Nápověda'),
                  onTap: ()
                  {
                    Navigator.push(context, new MaterialPage(builder: (context) => new HelpPage()))
                  },
                ),
              ),
             // const PopupMenuItem(
                //child: ListTile(
                //  leading: Icon(Icons.article),
                 // title: Text('Nevime'),
               // ),
             // ),
              //const PopupMenuDivider(),
             // const PopupMenuItem(child: Text('Item A')),
              //const PopupMenuItem(child: Text('Item B')),
            ],
          ),
        ],
      ),
      body: Center(),
    );
  }
}



