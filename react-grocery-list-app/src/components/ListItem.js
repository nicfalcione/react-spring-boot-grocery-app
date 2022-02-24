import { useStoreActions } from 'easy-peasy';
import React from 'react';
import { FaTrashAlt } from "react-icons/fa";

const ListItem = ({ item }) => {
    const handleCheck = useStoreActions((actions) => actions.handleCheck)
    const deleteItem = useStoreActions((actions) => actions.deleteItem)

    return (
        <li className='item'>
            <input
                type="checkbox"
                onChange={() => handleCheck(item.id)}
                checked={item.checked}
            />
            <label
                style={(item.checked) ? { textDecoration: 'line-through' } : null}
                onDoubleClick={() => handleCheck(item.id)}
            >{item.item}</label>
            <FaTrashAlt
                role="button"
                onClick={() => deleteItem(item.id)}
                tabIndex="0"
                aria-label={`Delete ${item.item}`}
            />
        </li>
    )
}

export default ListItem