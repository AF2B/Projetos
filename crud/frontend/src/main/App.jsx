import React from 'react'
import './App.css'

import Logo from '../components/templates/Logo'
import Nav from '../components/templates/Nav'
import Main from '../components/templates/Main'
import Footer from '../components/templates/Footer'

import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.min.css'

export default props =>
    <div className='app'>
        <Logo />
        <Nav />
        <Main icon="home" title="Início" />
        <Footer />
    </div>