import React from 'react';
import 'antd/dist/antd.css';
import '../pages/RegisterPage/RegisterPage.css';
import {
  Form,
  Input,
  Select,
  DatePicker
} from 'antd';

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

const RegisterForm = React.forwardRef((props, ref) => {
    const [form] = Form.useForm();

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

    return (
        <div ref={ref}>
            <Form
                {...formItemLayout}
                form={form}
                name="register"
                // onFinish={onFinish}
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
            </Form>
        </div>
    )
})

export default RegisterForm;
