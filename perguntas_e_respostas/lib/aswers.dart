import 'package:flutter/material.dart';
import './main.dart';

class Aswers extends StatelessWidget {
  final String text;

  final void Function() onSelection;

  Aswers(this.text, this.onSelection);

  @override
  Widget build(BuildContext context) {
    return Container(
        width: double.infinity,
        child: ElevatedButton(
            style: ElevatedButton.styleFrom(
                primary: Colors.blue,
                textStyle: TextStyle(color: Colors.grey[200])),
            onPressed: onSelection,
            child: Text(text))
            );
  }
}
