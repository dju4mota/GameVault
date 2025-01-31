// FormField.jsx
import styled from '@emotion/styled';

const FormContainer = styled.div`
  margin: 10px 0;
  display: flex;
  flex-direction: ${props => props.layout?.includes('column') ? 'column' : 'row'};
  align-items: ${props => props.align || 'flex-start'};
  gap: 8px;
`;

const Label = styled.label`
  font-family: "Montserrat", sans-serif;
  font-weight: ${props => props.bold ? '600' : '400'};
  font-size: ${props => props.fontSize || '16px'};
  display: flex;
  flex-direction: ${props => props.labelLayout || 'column'};
  gap: 5px;
`;

const Input = styled.input`
  padding: 8px 12px;
  border: 1px solid #000;
  border-radius: 4px;
  filter: drop-shadow(3px 3px 3px rgba(0, 0, 0, 0.2));
  width: ${props => props.fullWidth ? '100%' : 'auto'};
  font-family: "Montserrat", sans-serif;
  font-size: 16px;

  &:focus {
    outline: 2px solid #ff4800;
  }
`;

// Add specific variants
const nomeJogoStyles = {
  fontSize: '18px',
  fontWeight: '600',
  input: {
    height: '40px',
    padding: '10px'
  }
};

const FormField = ({ 
  label, 
  name, 
  type = 'text',
  value, 
  onChange, 
  placeholder,
  component: Component,
  variant,
  ...props
}) => (
  <FormContainer layout={props.layout} align={props.align}>
    <Label 
      bold={variant === 'title'}
      fontSize={variant === 'title' ? '18px' : null}
      labelLayout={props.labelLayout}
    >
      {label}
      {Component ? (
        <Component 
          name={name} 
          value={value} 
          onChange={onChange} 
          style={variant === 'title' ? nomeJogoStyles.input : {}}
        />
      ) : (
        <Input
          type={type}
          name={name}
          value={value}
          onChange={onChange}
          placeholder={placeholder}
          fullWidth
          css={variant === 'title' ? nomeJogoStyles.input : {}}
          {...props}
        />
      )}
    </Label>
  </FormContainer>
);

export default FormField;