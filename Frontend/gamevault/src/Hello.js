import React,
{ useState, useEffect } from 'react';

function Hello() {
    const [message, setMessage] = useState(""); useEffect(() => {
        fetch('/api/hello', {
            headers: {
                'Cache-Control': 'no-cache',
            },
        }).then(response => response.text()).then(message => { setMessage(message); });
    }, []);
    return <h1>{message}</h1>;
}
export default Hello;