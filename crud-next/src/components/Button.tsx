interface ButtonProps {
    cor?: 'black' | 'gray' | 'white'
    className?: string
    children: any;
    onClick?: () => void
}

export default function Button(props) {
    return (
        <button onClick={props.onClick} className="bg-gradient-to-r 
        from-black 
        to-gray-400 
        text-gray-300 
        px-4 py-2 rounded-md mb-3">
            {props.children}
        </button>
    )
}