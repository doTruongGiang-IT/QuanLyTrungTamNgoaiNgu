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
    let current_examination = JSON.parse(localStorage.getItem("current_examination"));
    let formValue = {
        identityCard: "",
        firstName: "",
        lastName: "",
        gender: "",
        dayOfBirth: "",
        placeOfBirth: "",
        dayProvide: "",
        placeProvide: "",
        phoneNumber: "",
        email: "",
        level: ""
    };

    const onFinish = (values) => {
        let dayOfBirth = document.evaluate('//*[@id="register_dayOfBirth"]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
        let dayProvide = document.evaluate('//*[@id="register_dayProvide"]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
        let gender = document.evaluate('//*[@id="register"]/div[5]/div[2]/div/div/div/div/span[2]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
        let level = document.evaluate('//*[@id="register"]/div[8]/div[2]/div/div/div/div/span[2]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
        
        for(let key in formValue) {
            if(values.target.id.includes(key)) {
                formValue[key] = values.target.value;
            };
            if(dayOfBirth.title !== "") {
                formValue.dayOfBirth = dayOfBirth.title;
            };
            if(dayProvide.title !== "") {
                formValue.dayProvide = dayProvide.title;
            };
            if(gender.title !== "") {
                formValue.gender = gender.title === "Nam" ? "male" : "female";
            };
            if(level.title !== "") {
                formValue.level = level.title;
            };
        };

        props.checkForm(formValue);
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

    return (
        <div ref={ref}>
            <Form
                {...formItemLayout}
                form={form}
                name="register"
                // onChange={onFinish}
                initialValues={{
                    prefix: '84',
                }}
                scrollToFirstError
            >

                <Form.Item
                    name="examination"
                    label="Kỳ thi"
                >
                    <Input defaultValue={props.currentExamination ? props.currentExamination : current_examination.name} disabled={true} />
                </Form.Item>

                <Form.Item
                    name="identityCard"
                    label="Số CMND"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy nhập số cmnd của bạn!',
                    },
                    {
                        pattern: "^([0-9]{10,12})$",
                        message: "Hãy nhập số cmnd với 10-12 ký tự số"
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="firstName"
                    label="Họ"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy nhập họ của bạn!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="lastName"
                    label="Tên"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy nhập tên của bạn!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="gender"
                    label="Giới tính"
                    rules={[{ required: true, message: 'Hãy chọn giới tính!' }]}
                >
                    <Select placeholder="Hãy chọn giới tính">
                        <Option value="male">Nam</Option>
                        <Option value="female">Nữ</Option>
                    </Select>
                </Form.Item>

                <Form.Item
                    name="phoneNumber"
                    label="Số điện thoại"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy nhập số điện thoại!',
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
                        message: 'Dữ liệu nhập vào không phải E-mail!',
                    },
                    {
                        required: true,
                        message: 'Hãy nhập E-mail!',
                    },
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="level"
                    label="Trình độ đăng ký"
                    rules={[{ required: true, message: 'Hãy chọn trình độ!' }]}
                >
                    <Select placeholder="Hãy chọn trình độ">
                        <Option value="B1">B1</Option>
                        <Option value="A2">A2</Option>
                    </Select>
                </Form.Item>

                <Form.Item
                    name="dayOfBirth"
                    label="Ngày sinh"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy chọn ngày sinh!',
                    }
                    ]}
                >
                    <DatePicker style={{width: "100%"}} onChange={onChange} />
                </Form.Item>

                <Form.Item
                    name="placeOfBirth"
                    label="Nơi sinh"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy nhập nơi sinh!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="dayProvide"
                    label="Ngày cấp CMND"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy chọn ngày cấp CMND!',
                    }
                    ]}
                >
                    <DatePicker style={{width: "100%"}} onChange={onChange} />
                </Form.Item>

                <Form.Item
                    name="placeProvide"
                    label="Nơi cấp CMND"
                    rules={[
                    {
                        required: true,
                        message: 'Hãy nhập nơi cấp CMND!',
                    }
                    ]}
                >
                    <Input />
                </Form.Item>
            </Form>
        </div>
    )
})

export default RegisterForm;
