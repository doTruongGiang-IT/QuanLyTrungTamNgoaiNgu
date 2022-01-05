import React, {useState} from 'react';
import '../pages/SearchPage/SearchPage.css';
import { Table, Space, Button, Modal} from 'antd';
import { EditOutlined, EyeOutlined, BookOutlined } from '@ant-design/icons';

const TableComponent = ({tab, search, examination, room}) => {
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [content, setContent] = useState("");
    const [name, setName] = useState("");

    const handleCancel = () => {
        setIsModalVisible(false);
    };

    const handleClickDetail = (id) => {
        console.log(id);
        setIsModalVisible(true);
        setContent("detail");
    };

    const handleClickResult = (id) => {
        const result = {candidate_id: id, examination_id: examination, room_id: room};
        console.log(result);
        setIsModalVisible(true);
        setContent("result");
    };

    const handleClickCertificate = (name) => {
        setContent("certificate");
        setName(name);
        setIsModalVisible(true);
    };

    const columnsSchedule = [
        {
            title: 'Số báo danh',
            dataIndex: 'candidate_no',
            key: 'candidate_no',
            width: '25%'
        },
        {
            title: 'Trình độ',
            dataIndex: 'level',
            key: 'level',
            width: '25%'
        },
        {
            title: 'Phòng thi',
            dataIndex: 'room',
            key: 'room',
            width: '25%'
        },
        {
            title: 'Ca thi',
            key: 'time',
            dataIndex: 'time',
            width: '25%'
        },
    ];

    const columnsScore = [
        {
            title: 'Nghe',
            dataIndex: 'listening',
            key: 'listening',
            width: '25%'
        },
        {
            title: 'Đọc',
            dataIndex: 'reading',
            key: 'reading',
            width: '25%'
        },
        {
            title: 'Viết',
            dataIndex: 'writing',
            key: 'writing',
            width: '25%'
        },
        {
            title: 'Nói',
            key: 'speaking',
            dataIndex: 'speaking',
            width: '25%'
        },
    ];

    const columnsCandidates = [
        {
            title: 'STT',
            dataIndex: 'stt',
            key: 'stt',
            width: '20%'
        },
        {
            title: 'Số báo danh',
            dataIndex: 'candidate_no',
            key: 'candidate_no',
            width: '20%'
        },
        {
            title: 'Họ tên',
            dataIndex: 'name',
            key: 'name',
            width: '20%'
        },
        {
            title: 'Số điện thoại',
            key: 'phone',
            dataIndex: 'phone',
            width: '20%'
        },
        {
            title: 'Liên kết',
            width: '20%',
            render: (_, record) => {
                return(
                    <Space>
                        <Button
                            onClick={() => handleClickDetail(record.id)}
                            type="primary"
                            disabled={(examination === 0 || room === 0) ? true : false}
                            icon={<EditOutlined />}
                            size="medium"
                            style={{ width: 80 }}
                        />
                        <Button
                            onClick={() => handleClickResult(record.id)}
                            disabled={(examination === 0 || room === 0) ? true : false}
                            type="primary"
                            icon={<EyeOutlined />}
                            size="medium"
                            style={{ width: 80 }}
                        />
                        <Button
                            onClick={() => handleClickCertificate(record.name)}
                            disabled={(examination === 0 || room === 0) ? true : false}
                            type="primary"
                            icon={<BookOutlined />}
                            size="medium"
                            style={{ width: 80 }}
                        />
                    </Space>
                )
            }
        },
    ];

    const dataSchedule = [
        {
            "key": 1,
            "candidate_no": "A2001",
            "level": "A2",
            "room": "A2P06",
            "time": "morning"
        }
    ];

    const dataScore = [
        {
            "key": 1,
            "listening": 8,
            "reading": 7.5,
            "writing": 6,
            "speaking": 5.5,
        }
    ];

    const dataCandidates = [
        {
            "key": 1,
            "stt": 1,
            "candidate_no": "A2001",
            "name": "Do Truong Giang",
            "phone": "0776134908",
        },
        {
            "key": 2,
            "stt": 2,
            "candidate_no": "A2002",
            "name": "Luu Thanh Dat",
            "phone": "0907236436",
        },
        {
            "key": 3,
            "stt": 3,
            "candidate_no": "A2003",
            "name": "Le Dang Khanh Dung",
            "phone": "0802436845",
        },
    ];

    return (
        <>
            <Table columns={tab === "schedule" ? columnsSchedule : (tab === "score" ? columnsScore : columnsCandidates)} dataSource={tab === "schedule" ? dataSchedule : (tab === "score" ? dataScore : dataCandidates)} pagination={false} />
            <Modal title="Thông tin chi tiết" visible={isModalVisible} footer={[]} onCancel={handleCancel}>
            {
                content === "detail" ? 
                <p>Detail</p> : (
                    content === "result" ?
                    <p>Result</p> :
                    <div className='certificate' style={{height: "380px"}}>
                        <h2 style={{textAlign: "center", marginTop: 130}}>{name}</h2>
                    </div>
                )
            }
            </Modal>
        </>
    )
}

export default TableComponent;
