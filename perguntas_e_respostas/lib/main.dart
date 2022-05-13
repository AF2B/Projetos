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

  final List<Map<String, Object>> questions = [
    {
      'texto': 'Qual sua cor favorita?',
      'respostas': ['Preto', 'Vermelho', 'Verde', 'Branco'],
    },
    {
      'texto': 'Qual o seu animal favorito?',
      'respostas': ['Coelho', 'Cobra', 'Elefante', 'Leão'],
    },
    {
      'texto': 'Qual seu instrumento músical favorito?',
      'respostas': ['Guitarra', 'Baixo', 'Bateria', 'Piano'],
    }
    ];

    List<Widget> aswer = [];
    //FIXME
    for (String textAswer in questions[selectedQuestion].cast()['respostas']) {
      aswer.add(Aswers(textAswer, _aswer));
    }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Perguntas'),
        ),
        body: Column(
          children: <Widget>[
            Question(questions[selectedQuestion]['texto'].toString()),
            ...aswer
          ],
        ),
      ),
    );
  }
}
