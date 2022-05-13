import 'package:flutter/material.dart';

void main() {
  runApp(PerguntaApp());
}

class PerguntaApp extends StatefulWidget {
  @override
  State<PerguntaApp> createState() => _PerguntaAppState();
}

class _PerguntaAppState extends State<PerguntaApp> {
  int selectedQuestion = 0;

  void aswer() {
    setState(() {
      selectedQuestion++;
    });
  }

  final List<String> questions = [
    'Qual sua cor favorita?',
    'Qual o seu animal favorito?'
  ];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Perguntas'),
        ),
        body: Column(
          children: [
            Text(questions.elementAt(selectedQuestion)),
            ElevatedButton(
              child: Text('Resposta 1'),
              onPressed: aswer,
            ),
            ElevatedButton(
              child: Text('Resposta 2'),
              onPressed: aswer,
            ),
            ElevatedButton(
              child: Text('Resposta 3'),
              onPressed: aswer,
            ),
          ],
        ),
      ),
    );
  }
}
