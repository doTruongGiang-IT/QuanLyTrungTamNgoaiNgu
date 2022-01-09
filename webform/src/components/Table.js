import React, {useState} from 'react';
import '../pages/SearchPage/SearchPage.css';
import { Table, Space, Button, Modal} from 'antd';
import { EditOutlined, EyeOutlined, BookOutlined } from '@ant-design/icons';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from "../actions/index";

const TableComponent = ({tab, examination, room}) => {
    const dispatch = useDispatch();
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [content, setContent] = useState("");
    const [name, setName] = useState("");
    const search = useSelector(state => state.search);
    const candidate = useSelector(state => state.candidate.candidate);
    const candidatesOfRoom = useSelector(state => state.candidate.allCandidate);
    const rooms = useSelector(state => state.room);
    let searchResult = JSON.parse(localStorage.getItem("search_result"));
    let candidates = JSON.parse(localStorage.getItem("all_candidate_of_room_of_examination"));
    let allRoomOfExaminationAndLevel = JSON.parse(localStorage.getItem("all_room_of_examination_and_level"));
    let dataSchedule = [];
    let dataScore = [];
    let dataCandidates = [];
    let dataStats = [];

    const handleCancel = () => {
        setIsModalVisible(false);
    };

    const handleClickDetail = (id) => {
        setContent("detail");
        setIsModalVisible(true);
        dispatch(actions.getDetailOfCandidateRequest(id));
    };

    const handleClickResult = (name, phone) => {
        setContent("result");
        setIsModalVisible(true);
        dispatch(actions.searchResultRequest(name.trim(), phone.trim()));
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
            title: 'Họ tên',
            dataIndex: 'name',
            key: 'name',
            width: '20%'
        },
        {
            title: 'Số điện thoại',
            dataIndex: 'phone',
            key: 'phone',
            width: '20%'
        },
        {
            title: 'Email',
            key: 'email',
            dataIndex: 'email',
            width: '20%'
        },
        {
            title: 'Liên kết',
            width: '20%',
            render: (_, record) => {
                return(
                    <Space>
                        <Button
                            onClick={() => handleClickDetail(record.key)}
                            type="primary"
                            disabled={(examination === 0 || room === 0) ? true : false}
                            icon={<EditOutlined />}
                            size="medium"
                            style={{ width: 80 }}
                        />
                        <Button
                            onClick={() => handleClickResult(record.name, record.phone)}
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

    const columnStats = [
        {
            title: 'Tên phòng',
            dataIndex: 'name',
            key: 'name',
            width: '50%'
        },
        {
            title: 'Số lượng thí sinh',
            dataIndex: 'candidates',
            key: 'candidates',
            width: '50%'
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

    if(candidatesOfRoom.data) {
        dataCandidates = candidatesOfRoom.data.map((candidate, index) => {
            return {
                "key": candidate.id,
                "stt": index+1,
                "email": candidate.email,
                "name": candidate.first_name + " " + candidate.last_name,
                "phone": candidate.phone,
            };
        });
    };

    if(rooms.data) {
        dataStats = rooms.data.map((room, index) => {
            return {
                "key": index,
                "name": room.name,
                "candidates": room.count
            };
        });
    };

    return (
        <>
            <Table columns={tab === "schedule" ? columnsSchedule : (tab === "score" ? columnsScore : (tab === "candidates" ? columnsCandidates : columnStats))} dataSource={tab === "schedule" ? dataSchedule : (tab === "score" ? dataScore : (tab === "candidates" ? dataCandidates : dataStats))} pagination={false} />
            <Modal title="Thông tin chi tiết" visible={isModalVisible} footer={[]} onCancel={handleCancel}>
            {
                content === "detail" ? 
                (
                    <>
                        <p>identification: {candidate.identification}</p>
                        <p>issue_date: {candidate.issue_date}</p>
                        <p>issue_place: {candidate.issue_place}</p>
                        <p>email: {candidate.email}</p>
                        <p>first_name: {candidate.first_name}</p>
                        <p>last_name: {candidate.last_name}</p>
                        <p>gender: {candidate.gender}</p>
                        <p>date_of_birth: {candidate.date_of_birth}</p>
                        <p>place_of_birth: {candidate.place_of_birth}</p>
                        <p>phone: {candidate.phone}</p>
                    </>
                ) : (
                    content === "result" ?
                    (   
                        <>
                            <p>Listening: {search !== undefined ? search.candidateRoom?.score_listening : -1}</p> 
                            <p>Writing: {search !== undefined ? search.candidateRoom?.score_writing : -1}</p> 
                            <p>Reading: {search !== undefined ? search.candidateRoom?.score_reading : -1}</p> 
                            <p>Speaking: {search !== undefined ? search.candidateRoom?.score_speaking : -1}</p>
                        </>
                    ) :
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
