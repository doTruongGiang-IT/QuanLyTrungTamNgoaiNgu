import React, {useState} from 'react';
import '../pages/SearchPage/SearchPage.css';
import { Table, Space, Button, Modal} from 'antd';
import { EditOutlined, EyeOutlined, BookOutlined } from '@ant-design/icons';
import { useDispatch, useSelector } from 'react-redux';

const TableComponent = ({tab, examination, room}) => {
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [content, setContent] = useState("");
    const [name, setName] = useState("");
    const search = useSelector(state => state.search);
    let searchResult = JSON.parse(localStorage.getItem("search_result"));
    let candidates = JSON.parse(localStorage.getItem("all_candidate_of_room_of_examination"));
    let dataSchedule = [];
    let dataScore = [];
    let dataCandidates = [];

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

    if(search.message === undefined) {
        dataSchedule = [
            {
                "key": 1,
                "candidate_no": search !== undefined ? search.candidateRoom?.candidate_no : "",
                "level": search !== undefined ? search.schedule?.level : "",
                "room": search !== undefined ? search.schedule?.room : "",
                "time": search !== undefined ? search.schedule?.time : ""
            }
        ];
    
        dataScore = [
            {
                "key": 1,
                "listening": search !== undefined ? search.candidateRoom?.score_listening : -1,
                "reading": search !== undefined ? search.candidateRoom?.score_reading : -1,
                "writing": search !== undefined ? search.candidateRoom?.score_writing : -1,
                "speaking": search !== undefined ? search.candidateRoom?.score_speaking : -1,
            }
        ];
    }else {
        dataSchedule = [
            {
                "key": 1,
                "candidate_no": "Not found",
                "level": "Not found",
                "room": "Not found",
                "time": "Not found"
            }
        ];
    
        dataScore = [
            {
                "key": 1,
                "listening": "Not found",
                "reading": "Not found",
                "writing": "Not found",
                "speaking": "Not found",
            }
        ];
    };

    
    dataCandidates = candidates.data.map((candidate, index) => {
        return {
            "key": index,
            "stt": index+1,
            "email": candidate.email,
            "name": candidate.first_name + candidate.last_name,
            "phone": candidate.phone,
        };
    });

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
