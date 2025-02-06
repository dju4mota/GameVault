
import styled from '@emotion/styled';

const FormContainer = styled.div`
  margin: 0;
  display: flex;
  flex-direction: ${props => props.layout?.includes('column') ? 'column' : 'row'};
  align-items: ${props => props.align || 'flex-start'};
  gap: 8px;
  width: 100%;  // Adicione isso para garantir que o container ocupe toda a largura
  ${props => props.className ? `grid-column: ${props.className.includes('full-width') ? '1/-1' : 'auto'};` : ''}
`;

const Label = styled.label`
  font-family: "Montserrat", sans-serif;
  font-weight: ${props => props.bold ? '600' : '400'};
  font-size: ${props => props.fontSize || '16px'};
  display: flex;
  flex-direction: ${props => props.labelLayout || 'column'};
  gap: 5px;
  width: 100%;
`;

const Input = styled.input`
  padding: 8px 12px;
  border: 1px solid #000;
  filter: drop-shadow(3px 3px 3px rgba(0, 0, 0, 0.2));
  width: ${props => props.fullWidth ? '100%' : 'auto'};
  font-family: "Montserrat", sans-serif;
  font-size: 16px;

  &:focus {
    outline: 1px solid #ff4800;
  }
`;

const Textarea = styled.textarea`
  padding: 8px 12px;
  border: 1px solid #000;
  filter: drop-shadow(3px 3px 3px rgba(0, 0, 0, 0.2));
  width: 100%;
  font-family: "Montserrat", sans-serif;
  font-size: 16px;
  resize: vertical;
  min-height: 80px;

  &:focus {
    outline: 1px solid #ff4800;
  }
`;

const nomeJogoStyles = {
  fontSize: '18px',
  fontWeight: '600',
  input: {
    height: '40px',
    padding: '10px'
  }
};

const FormField = ({ 
  className,
  label, 
  name, 
  type = 'text',
  value, 
  onChange, 
  placeholder,
  width,
  component: Component,
  variant,
  ...props
}) => (
  <FormContainer 
  layout={props.layout} 
  align={props.align}
  className={className} // Passe a className para o container
>
  <Label /* ... */>
    {label}
    {Component ? (
      <Component /* ... */ />
    ) : type === 'textarea' ? ( // Adicione esta condição
      <Textarea
        name={name}
        value={value}
        onChange={onChange}
        placeholder={placeholder}
        css={variant === 'title' ? nomeJogoStyles.input : {}}
        {...props}
      />
    ) : (
      <Input
          type={type}
          name={name}
          value={value}
          onChange={onChange}
          placeholder={placeholder}
          width={width}
          css={variant === 'title' ? nomeJogoStyles.input : {}}
          {...props}
        />
      )}
    </Label>
  </FormContainer>
);

export default FormField;