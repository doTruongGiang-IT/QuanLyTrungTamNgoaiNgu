import React, {useRef} from 'react';
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

    return (
        <div className="register">
            <h1>Register Form</h1>
            <RegisterForm ref={registerFormRef} />
            <ReactToPrint
                trigger={() => <Button type="primary">Print</Button>}
                content={() => registerFormRef.current}
            />
        </div>
    )
}

export default RegisterPage;
