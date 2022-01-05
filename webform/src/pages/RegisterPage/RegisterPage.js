import React, {useRef, useState} from 'react';
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
    const registerFormRef = useRef();
    // const [disabled, setDisabled] = useState(true);

    // const checkForm = (formValue) => {
    //     setDisabled(!Object.values(formValue).every(val => val !== ""));
    // };

    return (
        <div className="register">
            <h1>Biểu mẫu đăng ký</h1>
            <RegisterForm ref={registerFormRef} />
            <ReactToPrint
                trigger={() => <Button type="primary">In phiếu</Button>}
                content={() => registerFormRef.current}
            />
        </div>
    )
}

export default RegisterPage;
