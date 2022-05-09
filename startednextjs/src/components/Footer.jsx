import Link from 'next/link'
import FooterCSS from '../styles/Footer.module.css'

export default function Footer() {
    return (
        <footer className={FooterCSS.footer}>
            <Link href="/">
                <button className={FooterCSS.button}>Perfil do criador</button>
            </Link>
        </footer>
    )
}