import React, {useRef, useState, useEffect} from 'react';
import {
  Button
} from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from "../../actions/index";
import ReactToPrint from 'react-to-print';
import RegisterForm from '../../components/RegisterForm';

const RegisterPage = () => {
    const dispatch = useDispatch();
    const registerState = useSelector(state => state.register);
    const currentExamination = useSelector(state => state.examination);
    const registerFormRef = useRef();

    useEffect(() => {
        dispatch(actions.getCurrentExaminationRequest());
    }, [dispatch]);
    // const [disabled, setDisabled] = useState(true);

    // const checkForm = (formValue) => {
    //     setDisabled(!Object.values(formValue).every(val => val !== ""));
    // };

    return (
        <div className="register">
            <h1>Biểu mẫu đăng ký</h1>
            <RegisterForm ref={registerFormRef} currentExamination={currentExamination.name} />
            <ReactToPrint
                trigger={() => <Button type="primary">In phiếu</Button>}
                content={() => registerFormRef.current}
            />
        </div>
    )
}

export default RegisterPage;
