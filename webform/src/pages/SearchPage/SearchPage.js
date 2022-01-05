import React, {useState} from 'react';
import './SearchPage.css';
import { Input, Divider, Button } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import { Tabs } from 'antd';
import TableComponent from '../../components/Table';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from "../../actions/index";

const { TabPane } = Tabs;
const { Search } = Input;

const SearchPage = () => {
    const dispatch = useDispatch();
    const search = useSelector(state => state.search);
    const [name, setName] = useState("");
    const [phone, setPhone] = useState("");

    const callback = (key) => {
        if(key === "schedule") {
            dispatch(actions.searchScheduleRequest(1));
        };
        if(key === "score") {
            dispatch(actions.searchScoreRequest(1));
        };
    };

    const handleSearch = () => {
        const search = {name, phone};
        console.log(search);
    };

    return (
        <div className="search">
            <div className='search_container'>
                <div className='search_info'>
                    {/* <Search placeholder="Please enter your exam number" enterButton="Search" size="large" /> */}
                    <Input placeholder="Please enter your name" value={name} onChange={e => setName(e.target.value)} />
                    <Input placeholder="Please enter your phone number" value={phone} onChange={e => setPhone(e.target.value)} />
                    <Button type="primary" icon={<SearchOutlined />} onClick={handleSearch}>Search</Button>
                    {/* <Divider style={{backgroundColor: "lightgrey"}} /> */}
                    {/* <h2><strong>Candidate Information</strong></h2>
                    <p><strong>Full name:</strong> Đỗ Trường Giang</p>
                    <p><strong>Day of Birth:</strong> 2000/07/05</p>
                    <p><strong>E-mail:</strong> dotruonggiang290@gmail.com</p> */}
                </div>
                <div className='search_result'>
                    <Tabs defaultActiveKey="schedule" onChange={callback} size='large' style={{width: "100%"}}>
                        <TabPane tab="Schedule" key="schedule">
                            <TableComponent tab="schedule" search={search} />
                        </TabPane>
                        <TabPane tab="Score" key="score">
                            <TableComponent tab="score" search={search} />
                        </TabPane>
                    </Tabs>
                </div>
            </div>
        </div>
    )
}

export default SearchPage;
