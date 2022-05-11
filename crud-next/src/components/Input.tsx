interface InputProps {
    text: string
    type?: 'text' | 'number'
    value: any
    valueChange?: (value: any) => void
    justRead?: boolean
    className?: string
}

export default function Input(props: InputProps) {
    return (
        <div className={`flex flex-col ${props.className}`}>
            <label className="mb-4">
                {props.text}
                <input type={props.type ?? 'text'} 
                value={props.value} 
                readOnly={props.justRead}
                onChange={event => props.valueChange?.(event.target.value)} 
                className={`border border-black rounded-lg focus:outline-none bg-gray-100
                px-4 py-2 ${props.justRead ? '' : 'focus:bg-gray-200'}`}/>
            </label>
        </div>
    )
}