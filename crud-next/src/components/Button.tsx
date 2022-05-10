interface ButtonProps {
    cor?: 'black' | 'gray' | 'white'
    className?: string
    children: any;
}

export default function Button(props) {
    return (
        <button className="bg-gradient-to-r 
        from-black 
        to-gray-400 
        text-gray-300 
        px-4 py-2 rounded-md mb-3">
            {props.children}
        </button>
    )
}