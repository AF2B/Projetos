import 'package:flutter/material.dart';
import './question.dart';
import './aswers.dart';

void main() {
  runApp(QuestionApp());
}

class QuestionApp extends StatefulWidget {
  @override
  State<QuestionApp> createState() => _QuestionAppState();
}

class _QuestionAppState extends State<QuestionApp> {
  int _selectedQuestion = 0;

  int get selectedQuestion => _selectedQuestion;

  set selectedQuestion(int selectedQuestion) {
    _selectedQuestion = selectedQuestion;
  }

  void _aswer() {
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
          children: <Widget>[
            Question(questions.elementAt(selectedQuestion)),
            Aswers('Resposta 1', _aswer),
            Aswers('Resposta 2', _aswer),
            Aswers('Resposta 3', _aswer),
          ],
        ),
      ),
    );
  }
}
