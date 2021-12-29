import React from 'react';
import 'antd/dist/antd.css';
import './RegisterPage.css';
import {
  Form,
  Input,
  Select,
  Button,
  DatePicker,
  notification
} from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from "../../actions/index";

const { Option } = Select;

const formItemLayout = {
    labelCol: {
        xs: {
            span: 16,
        },
        sm: {
            span: 8,
        },
    },
    wrapperCol: {
        xs: {
            span: 16,
        },
        sm: {
            span: 12,
        },
    },
};

const tailFormItemLayout = {
    wrapperCol: {
        xs: {
            span: 12,
            offset: 8,
        },
        sm: {
            span: 13,
            offset: 3,
        },
    },
};

const RegisterPage = () => {
    const [form] = Form.useForm();
    const dispatch = useDispatch();
    const registerState = useSelector(state => state.register);
    const [api, contextHolder] = notification.useNotification();
    const Context = React.createContext();

    const convertUTCDateToLocalDate = (date) => {
        var newDate = new Date(date.getTime()+date.getTimezoneOffset()*60*1000);
        var offset = date.getTimezoneOffset() / 60;
        var hours = date.getHours();
        newDate.setHours(hours - offset);
        return newDate;   
    };

    const onFinish = async (values) => {
        let tempDateOfBirth = convertUTCDateToLocalDate(new Date(values.dayOfBirth._d));
        let tempDateProvide = convertUTCDateToLocalDate(new Date(values.dayProvide._d));
        let dateOfBirth = tempDateOfBirth.getFullYear()+"/"+tempDateOfBirth.getMonth()+1+"/"+tempDateOfBirth.getDate();
        let dateProvide = tempDateProvide.getFullYear()+"/"+tempDateProvide.getMonth()+"/"+tempDateProvide.getDate();
        values.dayOfBirth = dateOfBirth;
        values.dayProvide = dateProvide;
        delete values.prefix;
        // await dispatch(actions.registerRequest(values));
        if(!registerState.message) {
            openNotification('success', "Register Success!");
            form.resetFields();
        };
        if(registerState.message) {
            openNotification('error', registerState.message);
            form.resetFields();
        };
    };

    const prefixSelector = (
        <Form.Item name="prefix" noStyle>
            <Select
            style={{
                width: 70,
            }}
            >
            <Option value="84">+84</Option>
            <Option value="87">+87</Option>
            </Select>
        </Form.Item>
    );

    const onChange = (date, dateString) => {};

    const openNotification = (type, message) => {
        notification[type]({
            message: 'Notification',
            description: <Context.Consumer>{() => `${message}`}</Context.Consumer>,
        });
    };

    return (
        <div className="register">
            {contextHolder}
            <h1>Register Form</h1>
            <Form
                {...formItemLayout}
                form={form}
                name="register"
                onFinish={onFinish}
                initialValues={{
                    prefix: '84',
                }}
                scrollToFirstError
            >
                <Form.Item
                    name="identityCard"
                    label="Identity Card"
                    rules={[
                    {
                        required: true,
                        message: 'Please input your identity card!',
                    },
                    {
                        pattern: "^([0-9]{10})$",
                        message: "Please input right identity card with 10 digits"
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="firstName"
                    label="First Name"
                    rules={[
                    {
                        required: true,
                        message: 'Please input your first name!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="lastName"
                    label="Last Name"
                    rules={[
                    {
                        required: true,
                        message: 'Please input your last name!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="gender"
                    label="Gender"
                    rules={[{ required: true, message: 'Please select gender!' }]}
                >
                    <Select placeholder="Select your gender">
                        <Option value="male">Male</Option>
                        <Option value="female">Female</Option>
                    </Select>
                </Form.Item>

                <Form.Item
                    name="dayOfBirth"
                    label="Day of Birth"
                    rules={[
                    {
                        required: true,
                        message: 'Select your day of birth!',
                    }
                    ]}
                >
                    <DatePicker style={{width: "100%"}} onChange={onChange} />
                </Form.Item>

                <Form.Item
                    name="placeOfBirth"
                    label="Place of Birth"
                    rules={[
                    {
                        required: true,
                        message: 'Please input your place of birth!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="dayProvide"
                    label="Day Provide"
                    rules={[
                    {
                        required: true,
                        message: 'Select your day provide!',
                    }
                    ]}
                >
                    <DatePicker style={{width: "100%"}} onChange={onChange} />
                </Form.Item>

                <Form.Item
                    name="placeProvide"
                    label="Place Provide"
                    rules={[
                    {
                        required: true,
                        message: 'Please input your place provide!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="phoneNumber"
                    label="Phone Number"
                    rules={[
                    {
                        required: true,
                        message: 'Please input your phone number!',
                    },
                    ]}
                >
                    <Input
                    addonBefore={prefixSelector}
                    style={{
                        width: '100%',
                    }}
                    />
                </Form.Item>

                <Form.Item
                    name="email"
                    label="E-mail"
                    rules={[
                    {
                        type: 'email',
                        message: 'The input is not valid E-mail!',
                    },
                    {
                        required: true,
                        message: 'Please input your E-mail!',
                    },
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item {...tailFormItemLayout}>
                    <Button type="primary" htmlType="submit">
                        Register
                    </Button>
                </Form.Item>
            </Form>
        </div>
    )
}

export default RegisterPage;
