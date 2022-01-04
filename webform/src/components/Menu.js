import React, {useState} from 'react';
import { Menu } from 'antd';
import { useNavigate } from 'react-router';
import { SearchOutlined, UserOutlined, UsergroupAddOutlined, LineChartOutlined } from '@ant-design/icons';

const MenuComponent = () => {
    let navigate = useNavigate();
    const [currentKey, setCurrentKey] = useState("");

    const handleClick = e => {
        navigate(`/${e.key}`);
        setCurrentKey(e.key);
    };

    return (
        <Menu onClick={handleClick} selectedKeys={[currentKey]} mode="horizontal" style={{backgroundColor: "whitesmoke", padding: "0 30px"}}>
            <Menu.Item key="" icon={<UserOutlined />}>
                HOME
            </Menu.Item>
            <Menu.Item key="search" icon={<SearchOutlined />}>
                SEARCH
            </Menu.Item>
            <Menu.Item key="candidates" icon={<UsergroupAddOutlined />}>
                CANDIDATES
            </Menu.Item>
            <Menu.Item key="stats" icon={<LineChartOutlined />}>
                STATS
            </Menu.Item>
        </Menu>
    )
}

export default MenuComponent;
